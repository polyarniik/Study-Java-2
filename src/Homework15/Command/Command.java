package Homework15.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface Command {
    Path execute(Path path, String request, File file) throws IOException;
}
