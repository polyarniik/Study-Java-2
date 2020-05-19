package Homework16;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Scanner;

public class URIDownload {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            URL url = new URL(sc.nextLine());
            URLConnection connection = url.openConnection();
            String type = connection.getContentType();
            type = type.split("/")[1];
            InputStream is = connection.getInputStream();
            String name = "file." + type;
            File file = new File("./src/Homework16/" + name);
            Files.copy(is, file.toPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}