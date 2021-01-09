package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Pattern;

public class Main {

    private static final String sitePath = "https://lenta.ru";
    private static final String downloadDirectoryPath = "downloads";

    public static void main(String[] args)
    {
        try {

            Document htmlDocument = Jsoup.connect(sitePath).get();
            Elements elementsIMG = htmlDocument.select("img");
            System.out.println("Вы загрузили в " + downloadDirectoryPath + " следующие файлы:");
            for (Element e : elementsIMG) {
                downloadImage(e.attr("abs:src"), downloadDirectoryPath);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void downloadImage(String url, String directoryPath) throws Exception
    {
        String[] splitURL = url.split("/");
        String picName = splitURL[splitURL.length - 1];
        if (checkPicName(picName)) {
            File newDirectory = new File(directoryPath);
            newDirectory.mkdir();
            System.out.println(picName);
            InputStream in = new URI(url).toURL().openStream();
            Files.copy(in, Paths.get(newDirectory + "/" + picName), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static boolean checkPicName(String name) {
        if (Pattern.matches("^.+\\.jpg$", name)) return true;
        else return false;
    }
}
