package Homework8;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

public class Input {
    public static void main(String[] args) {
        File file = new File("C:/Users/russa/Desktop/Projects/Study-Java 2/src/Homework8/test.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            int n = (fis.read() << 24) + (fis.read() << 16) + (fis.read() << 8) + fis.read();
            char c = (char) ((fis.read() << 8) + fis.read());
            System.out.println(n);
            System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
