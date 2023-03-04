package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        HttpStatusChecker checker = new HttpStatusChecker();

        String imageUrl = checker.getStatusImage(200);
        System.out.println("Image URL: " + imageUrl);

        String imageUrl1 = checker.getStatusImage(300);
        System.out.println("Image URL1: " + imageUrl1);

        try {
            String imageUrl2 = checker.getStatusImage(10000);
            System.out.println("Image URL2: " + imageUrl2);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        downloader.downloadStatusImage(200);
        downloader.downloadStatusImage(101);
        try {
            downloader.downloadStatusImage(10000);
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }


}

