package Homework15.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Delete implements Command{
    @Override
    public Path execute(Path path, String request, File file) throws IOException {
        file = new File(String.valueOf(path.resolve(request.substring(4))));
        if (file.exists()) {
            delete(file);
        } else System.out.println("The system cannot find the specified path!");
        return path;
    }

    private void delete(File file) {
        if(file.isDirectory()) {
            for (File f : file.listFiles()) {
                delete(f);
            }
        }
        file.delete();
    }
}
