package com.company;

import java.io.File;

public class Main {

    private static final String SITEPATH = "https://lenta.ru";
    private static final String DOWNLOADDIRECTORYPATH = "downloads/sdfk";

    public static void main(String[] args)
    {
        try {

            ImageDownloader imageDownloader = new ImageDownloader(SITEPATH, DOWNLOADDIRECTORYPATH);
            imageDownloader.downloadImages();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
