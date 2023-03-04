package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    private static final String DOWNLOAD_FOLDER = "./";

    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = DOWNLOAD_FOLDER + code + ".jpg";
            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[1024];
                int bytesRead = -1;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Image downloaded: " + fileName);
        } else {
            throw new RuntimeException("Status image not found for code " + code);
        }
    }
}
