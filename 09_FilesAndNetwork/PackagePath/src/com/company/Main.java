package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до пакпки или файла в формате C:/Users/User/folder");
        for (; ; ){
            try {
                String path = scanner.nextLine();
                getSize(path);
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
                ex.printStackTrace();
            }
        }
    }

    public static void getSize(String path) {
        long volume;
        File fileOrFolder = new File(path);
        volume = size(fileOrFolder);
        if (volume == 0) System.out.println("Папка пуста");
        else if (volume == -1 ) System.out.println("Папки или файла не существует");
        else System.out.println("Размер папки (" + path + ") равен " + volumeCorrector(volume));
    }

    public static long size(File path){
        long volume = 0;
        if (path.exists()) {
            if (path.isFile()) volume += path.length();
            else {
                for (File file : path.listFiles()) {
                    volume += size(file);
                }
            }
            return volume;
        }
        else return -1;
    }

    public static String volumeCorrector(long volume){
        if (volume < 1024) {
            return volume + " b";
        }
        if (volume >= 1024 && volume < (1024*1024)) {
            return volume/1024 + " Kb";
        }
        if (volume >= (1024*1024) && volume < (1024*1024*1024)) {
            return volume/(1024*1024) + " Mb";
        }
        else return volume/(1024*1024*1024) + " Gb";
    }
}

