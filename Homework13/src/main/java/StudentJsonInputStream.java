import Homework8.Input;
import Homework9.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentJsonInputStream extends InputStream {
    private DataInputStream dis;

    public StudentJsonInputStream(InputStream is) {
        this.dis = new DataInputStream(is);
    }

    public Student readStudent() throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue((DataInput) dis, Student.class);
    }

    public int read() throws IOException {
        return dis.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return dis.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return dis.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return dis.skip(n);
    }

    @Override
    public int available() throws IOException {
        return dis.available();
    }

    @Override
    public void close() throws IOException {
        dis.close();
    }

    @Override
    public void mark(int readlimit) {
        dis.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        dis.reset();
    }

    @Override
    public boolean markSupported() {
        return dis.markSupported();
    }

    public void readFully(byte[] b) throws IOException {
        dis.readFully(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        dis.readFully(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        return dis.skipBytes(n);
    }

    public boolean readBoolean() throws IOException {
        return dis.readBoolean();
    }

    public byte readByte() throws IOException {
        return dis.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return dis.readUnsignedByte();
    }

    public short readShort() throws IOException {
        return dis.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return dis.readUnsignedShort();
    }

    public char readChar() throws IOException {
        return dis.readChar();
    }

    public int readInt() throws IOException {
        return dis.readInt();
    }

    public long readLong() throws IOException {
        return dis.readLong();
    }

    public float readFloat() throws IOException {
        return dis.readFloat();
    }

    public double readDouble() throws IOException {
        return dis.readDouble();
    }

    @Deprecated
    public String readLine() throws IOException {
        return dis.readLine();
    }

    public String readUTF() throws IOException {
        return dis.readUTF();
    }

    public static String readUTF(DataInput in) throws IOException {
        return DataInputStream.readUTF(in);
    }
}
