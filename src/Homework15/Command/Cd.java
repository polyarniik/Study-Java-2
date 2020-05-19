package Homework15.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Cd implements Command {

    @Override
    public Path execute(Path path, String request, File file) {
        try {
            path = this.cd(path, request, file);
        } catch (FileNotFoundException ex) {
            System.out.println("The system cannot find the specified path!");
        }
        return path;
    }

    public Path cd(Path path, String request, File file) throws FileNotFoundException {
        request = request.substring(3);
        path = path.resolve(request);
        file = new File(path.toString());
        if (file.exists() && file.isDirectory()) {
            return path;
        } else throw new FileNotFoundException();
    }
}
