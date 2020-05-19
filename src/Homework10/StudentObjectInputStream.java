package Homework10;

import Homework9.Student;

import java.io.*;

public class StudentObjectInputStream extends InputStream {
    ObjectInputStream ois;

    public StudentObjectInputStream(InputStream is) throws IOException {
        this.ois = new ObjectInputStream(is);
    }

    public Student readStudent() throws IOException {
        return new Student(readUTF(), readChar(), readUTF(), readInt());
    }

    @Override
    public int read() throws IOException {
        return ois.read();
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        return ois.readUnshared();
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
    }

    public ObjectInputStream.GetField readFields() throws IOException, ClassNotFoundException {
        return ois.readFields();
    }

    public void registerValidation(ObjectInputValidation obj, int prio) throws NotActiveException, InvalidObjectException {
        ois.registerValidation(obj, prio);
    }

    public boolean readBoolean() throws IOException {
        return ois.readBoolean();
    }

    public byte readByte() throws IOException {
        return ois.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return ois.readUnsignedByte();
    }

    public char readChar() throws IOException {
        return ois.readChar();
    }

    public short readShort() throws IOException {
        return ois.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return ois.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return ois.readInt();
    }

    public long readLong() throws IOException {
        return ois.readLong();
    }

    public float readFloat() throws IOException {
        return ois.readFloat();
    }

    public double readDouble() throws IOException {
        return ois.readDouble();
    }

    public void readFully(byte[] buf) throws IOException {
        ois.readFully(buf);
    }

    public void readFully(byte[] buf, int off, int len) throws IOException {
        ois.readFully(buf, off, len);
    }

    public int skipBytes(int len) throws IOException {
        return ois.skipBytes(len);
    }

    @Deprecated
    public String readLine() throws IOException {
        return ois.readLine();
    }

    public String readUTF() throws IOException {
        return ois.readUTF();
    }
}
