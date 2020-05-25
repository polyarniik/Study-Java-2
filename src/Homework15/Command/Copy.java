package Homework15.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Copy implements Command {

    @Override
    public Path execute(Path path, String request, File file) throws IOException {
        request = request.substring(5);
        Path outgoingPath = path.resolve(request.split(" to")[0]);
        Path ingoingPath = path.resolve(request.split("to ")[1] + "\\");
        Files.copy(outgoingPath, ingoingPath);
        return path;
    }
}
