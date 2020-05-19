package collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int cursor;
    private int count = 1;

    public ArrayIterator(T[] array) {
        this.array = array;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if (array.length <= cursor) return false;
        return true;
    }

    @Override
    public T next() {
        try {
            T elem = array[cursor];
            if(cursor <= array.length/2) {
                cursor = array.length-count++;
            }
            else cursor = array.length - cursor;
            return elem;
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        ArrayIterator<Integer> it = new ArrayIterator<Integer>(arr);

        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}
