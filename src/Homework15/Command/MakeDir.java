package Homework15.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeDir implements Command {

    @Override
    public Path execute(Path path, String request, File file) throws IOException {
        path = this.makeDir(path, request, file);
        return path;
    }

    public Path makeDir(Path path, String request, File file) throws IOException {
        request = request.substring(6);
        Pattern pattern = Pattern.compile("[\\sa-zA-Zà-ÿÀ-ß0-9\\.\\-~]+");
        Matcher matcher = pattern.matcher(request);
        matcher.find();
        while (matcher.find()) {
            for (File f : file.listFiles()) {
                if (f.getName().equals(matcher.group())) {
                    System.out.println("A directory with the same name already exists!");
                    return path;
                }
            }
            path = path.resolve(matcher.group());
            new File(String.valueOf(path)).mkdir();
        }
        return path;
    }
}
