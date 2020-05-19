package Homework15.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ParentDir implements Command {

    @Override
    public Path execute(Path path, String request, File file) throws IOException {
        return this.getDir(path, file);

    }

    public Path getDir(Path path, File file) throws IOException {
        if (file.getParent() != null) {
            return path.getParent();
        }
        return path;
    }
}
