package Homework15.Command;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cat implements Command {

    @Override
    public Path execute(Path path, String request, File file) throws IOException {
        Path retPath = path;
        if (request.matches("C:\\.*")) {
            path = Paths.get(request.substring(4));
        } else path = Paths.get(String.valueOf(path.resolve(request.substring(4))));
        if (path.toString().contains(" in ")) {
            path = Paths.get(path.toString().substring(0, path.toString().indexOf(" in ")));
        }
        String encoding = "UTF-8";
        if (request.contains(" in ")) {
            encoding = request.substring(request.indexOf(" in ") + 4);
        }
        try {
            cat(path, encoding);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Unsupported encoding");
        }
        return retPath;
    }

    public void cat(Path path, String encoding) throws FileNotFoundException, UnsupportedEncodingException {
        BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(path.toString()), encoding));
        String str;
        try {
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException ex) {
            System.out.println("File cannot be read!");
        }
    }
}
