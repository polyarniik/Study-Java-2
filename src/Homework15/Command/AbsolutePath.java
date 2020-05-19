package Homework15.Command;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class AbsolutePath implements Command {
    @Override
    public Path execute(Path path, String request, File file) throws IOException {
        System.out.println("Unknown command!");
        return path;
    }
}
