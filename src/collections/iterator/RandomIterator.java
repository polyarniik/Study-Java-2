package collections.iterator;

import java.util.Iterator;

public class RandomIterator<T> implements Iterator<T> {
    private T[] data;
    private int cursor;

    public RandomIterator(T[] data){
        this.data = data;
        cursor = 0;
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
    public T next() {
            int a = (int) (Math.random()*data.length);
            T elem = data[a];
            cursor = a;
            return elem;
    }
}
