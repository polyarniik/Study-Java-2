package Homework20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Downloader implements Runnable {

    @Override
    public void run() {
        try {
            URL url = new URL("https://drive.google.com/u/0/uc?id=15ah3DFTeKPdSA3v2A0HKEVazsLFsSpWf&export=download");
            InputStream is = url.openConnection().getInputStream();
            FileOutputStream fos = new FileOutputStream("./src/Homework20/output.pdf");
            int c = is.read();
            try {
                while (c != -1) {
                    Thread.sleep(0, 50);
                    fos.write(c);
                    c = is.read();
                }
            } catch (InterruptedException ex) {
                System.out.println("Downloading not completed!");
                return;
            }
            System.out.println("Downloading completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
