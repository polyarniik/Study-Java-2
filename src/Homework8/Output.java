package Homework8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Output {
    public static void main(String[] args) {
        File file = new File("C:/Users/russa/Desktop/Projects/Study-Java 2/src/Homework8/test.txt");
        int n = 1831;
        char c = 'b';
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(n >> 24);
            out.write(n >> 16);
            out.write(n >> 8);
            out.write(n);
            out.write(c >> 8);
            out.write(c);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}