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

public class ImageDownloader {
    private Document htmlDocument;
    private String sitePath;
    private String directoryPath;

    public  ImageDownloader(String sitePath, String directoryPath )
    {
        this.sitePath = sitePath;
        this.directoryPath = directoryPath;

    }

    public void downloadImages() throws Exception
    {
        if (new File(directoryPath).isDirectory() || new File(directoryPath).mkdir())
        {
            htmlDocument  = Jsoup.connect(sitePath).get();
            Elements elementsIMG = htmlDocument.select("img");
            System.out.println("Вы загрузили в " + directoryPath + " следующие файлы:");
            for (Element e : elementsIMG) {
                download(e.attr("abs:src"), directoryPath);
            }
        }
        else System.out.println("Wrong directory path");
    }
    private static void download(String url, String directoryPath) throws Exception
    {
        String[] splitURL = url.split("/");
        String picName = splitURL[splitURL.length - 1];
        if (Pattern.matches("^.+\\.jpg$", picName)) {
            System.out.println(picName);
            InputStream in = new URI(url).toURL().openStream();
            Files.copy(in, Paths.get(directoryPath + "/" + picName), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
