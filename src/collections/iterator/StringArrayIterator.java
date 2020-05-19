package collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArrayIterator implements Iterator<String> {
    private String[] data;
    private int cursor;

    public StringArrayIterator(String[] data) {
        this.cursor =0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if(data.length <= cursor) {
            return false;
        }
        return true;
    }

    @Override
    public String next() {
//        if(!hasNext()) {
//            throw new NoSuchElementException();
//        }

        try {
            String el = data[cursor++];
            return el;
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }
}
