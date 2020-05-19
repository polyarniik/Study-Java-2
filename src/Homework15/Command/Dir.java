package Homework15.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Dir implements Command {


    @Override
    public Path execute(Path path, String request, File file) throws IOException {
        path = this.dir(path, file);
        return path;
    }

    public Path dir(Path path, File file) {
        int i = 1;
        for (File f : file.listFiles()) {
            System.out.println((i++) + ". " + f.getName());
        }
        return path;
    }
}
