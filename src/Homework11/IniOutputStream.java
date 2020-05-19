package Homework11;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class IniOutputStream extends OutputStream {
    DataOutputStream os;

    public IniOutputStream(OutputStream os) {
        this.os = new DataOutputStream(os);
    }

    public void writeIni(Map<String, Map<String, String>> iniMap){
        try (OutputStreamWriter out = new OutputStreamWriter(os)) {
            for (String section : iniMap.keySet()) {
                out.write("[" + section +"]\n");
                for(String name : iniMap.get(section).keySet()) {
                    out.write(name + "=" + iniMap.get(section).get(name) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(int b) throws IOException {
        os.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        os.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        os.flush();
    }

    public void writeBoolean(boolean v) throws IOException {
        os.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        os.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        os.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        os.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        os.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        os.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        os.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        os.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        os.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        os.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        os.writeUTF(str);
    }

    public int size() {
        return os.size();
    }

    @Override
    public void write(byte[] b) throws IOException {
        os.write(b);
    }

    @Override
    public void close() throws IOException {
        os.close();
    }

}
