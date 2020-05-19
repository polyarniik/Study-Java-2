package Homework9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StudentSerialization {


    public static void write(Collection<Student> coll, String path) {
        try (FileOutputStream fos = new FileOutputStream(new File(path))) {
            for (Student st : coll) {
                ByteBuffer bb = ByteBuffer.allocate(2 * (st.getName().length() + st.getBirthDay().length()) + 8);
                bb.put((byte) st.getName().length());
                for(char c: st.getName().toCharArray()) {
                    bb.putChar(c);
                }
                bb.putChar(st.getGender());
                bb.put((byte) st.getBirthDay().length());
                for(char c: st.getBirthDay().toCharArray()) {
                    bb.putChar(c);
                }
                bb.putInt(st.getGroupNumber());
                fos.write(bb.array());
                bb.clear();
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Collection<Student> read(String path) {
        List<Student> st = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path)) {
            int nameLength;
            while ((nameLength = fis.read()) != -1) {
                byte[] nameArr = new byte[nameLength*2];
                for (int i = 0; i < nameLength*2; i++) {
                    nameArr[i] = (byte) fis.read();
                }
                char gender = (char) ((fis.read() << 8) + fis.read());
                byte birthDayLength = (byte) fis.read();
                byte[] birthDayArr = new byte[birthDayLength*2];
                for (int i = 0; i < birthDayLength*2; i++) {
                    birthDayArr[i] = (byte) fis.read();
                }
                int groupNumber = (fis.read() << 24) + (fis.read() << 16) +
                        (fis.read() << 8) + fis.read();
                st.add(new Student(new String(nameArr), gender, new String(birthDayArr), groupNumber));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return st;
    }

    public static void main(String[] args) {
        List<Student> st = new ArrayList<>();
        st.add(new Student("Ivan", 'M', "12.07.19", 901));
        st.add(new Student("Masha", 'F', "29.03.1999", 902));
        st.add(new Student("Boris", 'M', "13 December", 903));
        st.add(new Student("Lena", 'F', "2 January", 904));
        st.add(new Student("Aleksandr", 'M', "15 January", 905));
        st.add(new Student("Dasha", 'F', "22 November", 906));
        write(st, "students.txt");
        Collection<Student> readSt = read("students.txt");
        for(Student s: readSt) {
            System.out.println(s.toString());
        }
    }
}