package collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringEventArrayIterator implements Iterator<String> {
    private int cursor;
    private String[] data;
    

    public StringEventArrayIterator(String[] data) {
        this.cursor = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = cursor; i < data.length; i += 2) {
            if (data[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String next() {
        try {
            while(data[cursor] == null) cursor += 2;
            String elem = data[cursor];
            cursor += 2;
            return elem;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        String[] arr ={"a", "1",  "t", "53",null, "fd", "gf", "ffd"};
        StringEventArrayIterator it = new StringEventArrayIterator(arr);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
