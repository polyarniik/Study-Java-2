package Homework20;

import java.io.File;
import java.util.Scanner;

public class Command implements Runnable {
    @Override
    public void run() {
        Thread load = new Thread(new Downloader());
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while(true) {
            if (command.matches("^start.*")) {
                load.start();
                System.out.println("Downloading...");
            }
            else if (command.matches("^status.*")) {
                File file = new File("./src/Homework20/output.pdf");
                System.out.println(((file.length() * 100) / (float) (3254 * 1024)) + " %");
            }
            else if (command.matches("^end.*")) {
                load.interrupt();
            }
            else {
                System.out.println("Unknown command!");
            }
            command = sc.nextLine();
        }
    }
}
