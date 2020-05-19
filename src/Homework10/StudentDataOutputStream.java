package Homework10;

import Homework9.Student;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StudentDataOutputStream extends OutputStream {
    DataOutputStream dos;

    public StudentDataOutputStream(OutputStream os) {
        this.dos = new DataOutputStream(os);
    }

    public void writeStudent(Student student) throws IOException {
        writeChars(student.getName());
        writeChar(student.getGender());
        writeChars(student.getBirthDay());
        writeInt(student.getGroupNumber());
    }

    @Override
    public void write(int b) throws IOException {
        dos.write(b);
    }

    public void writeBoolean(boolean v) throws IOException {
        dos.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        dos.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        dos.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        dos.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        dos.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        dos.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        dos.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        dos.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        dos.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        dos.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        dos.writeUTF(str);
    }

    public int size() {
        return dos.size();
    }
}
