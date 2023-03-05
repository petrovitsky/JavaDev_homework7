package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code:");
        String input = scanner.nextLine();

        try {
            int code = Integer.parseInt(input);
            String imageUrl = new HttpStatusChecker().getStatusImage(code);
            new HttpStatusImageDownloader().downloadStatusImage(code);
            System.out.println("Image for HTTP status " + code + " downloaded from " + imageUrl);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
            askStatus();
        } catch (Exception e) {
            System.out.println("There is not image for HTTP status " + input);
            askStatus();
        }
        scanner.close();
    }
}

