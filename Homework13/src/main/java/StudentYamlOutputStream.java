import Homework9.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;

public class StudentYamlOutputStream extends OutputStream {
    private DataOutputStream dos;

    public StudentYamlOutputStream(OutputStream os) {
        this.dos = new DataOutputStream(os);
    }

    public void writeStudent(Student student) throws IOException {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        om.writeValue((DataOutput) dos, student);
    }
    public void write(int b) throws IOException {
        dos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        dos.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        dos.flush();
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

    @Override
    public void write(byte[] b) throws IOException {
        dos.write(b);
    }

    @Override
    public void close() throws IOException {
        dos.close();
    }

}
