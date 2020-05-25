package Homework15;

import Homework15.Command.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        fileManager.start();
    }

    private boolean exit;
    private File file;
    private Path path;

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        path = Paths.get("C:\\");
        file = new File(path.toString());
        exit = true;
        while (exit) {
            System.out.print(path + ">");
            file = new File(String.valueOf(path));
            String request = sc.nextLine();
            if (request.matches("^exit")) {
                exit = false;
                break;
            }
            Command command = getCommand(request);
            path = command.execute(path, request, file);
        }
    }

    public Command getCommand(String request) {
        if (request.matches("\\s*cd\\s*..")) {
            return new ParentDir();
        }
        if (request.matches("^\\s*cd\\s[\\sa-zA-zà-ÿÀ-ÿ0-9~.\\-\\\\]+")) {
            return new Cd();
        }
        if (request.matches("^\\s*mkdir (.*)")) {
            return new MakeDir();
        }
        if (request.matches("^\\s*dir")) {
            return new Dir();
        }
        if (request.matches("^\\s*del\\s[\\sa-zA-zà-ÿÀ-ÿ0-9~.\\-\\\\]+")) {
            return new Delete();
        }
        if (request.matches("^\\s*copy\\s[\\sa-zA-zà-ÿÀ-ÿ0-9~.\\-\\\\]+to\\s[\\sa-zA-zà-ÿÀ-ÿ0-9~.\\-\\\\]+")) {
            return new Copy();
        }
        if (request.matches("^\\s*cat\\s[\\sa-zA-zà-ÿÀ-ÿ0-9~.\\-\\\\]+")) {
            return new Cat();
        }
        return new AbsolutePath();
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileManager that = (FileManager) o;
        return exit == that.exit &&
                Objects.equals(file, that.file) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exit, file, path);
    }
}