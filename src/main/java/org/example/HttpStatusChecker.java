package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) throws IOException {
        String imageUrl = BASE_URL + code + ".jpg";
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
            throw new RuntimeException("Status image not found for code " + code);
        }
        return imageUrl;
    }
}
