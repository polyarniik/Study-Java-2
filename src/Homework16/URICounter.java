package Homework16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URICounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            URL url = new URL(sc.nextLine());
            URLConnection connection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String page = "";
            String line;
            while ((line = br.readLine()) != null) {
                page += line + "\n";
            }
            Matcher matcherDiv = Pattern.compile("</div>").matcher(page);
            int countDiv = 0;
            while (matcherDiv.find()) countDiv++;
            Matcher matcherImg = Pattern.compile("<img.*>").matcher(page);
            int countImg = 0;
            while (matcherImg.find()) countImg++;
            System.out.println(countDiv + " " + countImg);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
