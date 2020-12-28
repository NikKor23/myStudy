package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            for (; ; ) {
                String from = takePathFrom("Введите путь к файлу, который необходимо скопировать");
                String to = takePathTo("Введите путь к папке, в которую необходимо скопировать");
                doCopy(from, to);
                System.out.println(doCopyCheck(from, to) ? "Файл успешно создан" : "Какая то ошипка");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static String takePathFrom(String massage) {
        for(;;){
            System.out.println(massage);
            File file = new File(scanner.nextLine().trim());
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            System.out.println("Файл или папка не найдены!");
        }
    }

    private static String takePathTo(String massage) {
        for(;;){
            System.out.println(massage);
            File file = new File(scanner.nextLine());
            if (file.isDirectory()) {
                return file.getAbsolutePath();
            }
            System.out.println("Папка не найдена");
        }
    }

    private static void copyFile(File file, String copyTo) throws IOException {
        Path path = Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(copyTo + "\\" + file.getName()), REPLACE_EXISTING);
    }

    private static void doCopy (String from, String to) throws IOException{
        if (sameFilesCheck(from, to)) {
            System.out.println("Вы указали одиноковые файлы!");
            return;
        }
        File fileOrDirectory = new File(from);
        if (fileOrDirectory.isFile()) copyFile(fileOrDirectory, to);
        if (fileOrDirectory.isDirectory()) {
            File createDir = new File(to + "\\" + fileOrDirectory.getName());
            createDir.mkdir();
            for (File file : fileOrDirectory.listFiles()) {
                doCopy(file.getAbsolutePath(), createDir.getAbsolutePath());
            }
        }
    }

    private static boolean sameFilesCheck(String from, String to) throws IOException {
        if (Files.isSameFile(Paths.get(from), Paths.get(to))) return true;
        else return false;
    }

    private static boolean doCopyCheck (String from,String to) throws IOException {
        Path fileName = Paths.get(from).getFileName();
        Path newFileAbsolutePath = Paths.get(to + "\\" +fileName);
        if (new File(newFileAbsolutePath.toString()).exists()) return true;
        else return false;
    }
}
