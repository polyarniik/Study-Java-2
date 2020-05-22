package Homework20;

public class Main {
    public static void main(String[] args) {
        Thread command = new Thread(new Command());
        command.start();
    }
}
