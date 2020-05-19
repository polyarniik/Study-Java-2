package collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EndlessArrayIterator<T> implements Iterator<T> {
    private T[] data;
    private int cursor;

    public EndlessArrayIterator(T... data) {
        this.data = data;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = cursor; i < data.length; i ++) {
            if (data[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        try {
            T elem = data[cursor++];
            return elem;
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }
}
