package collections.my;

import collections.iterator.EndlessArrayIterator;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;

public class UnmodifiableCollection<T> extends AbstractCollection<T> {
    private T[] data;
    private int size;

    public UnmodifiableCollection() {
        this.data = (T[]) new Object[0];
        this.size = data.length;
    }

    public UnmodifiableCollection(UnmodifiableCollection<? extends T> coll) {
        this.data = (T[]) new Object[coll.size()];
        Iterator<T> it = (Iterator<T>) coll.iterator();
        size = 0;
        for (T elem : coll) {
            data[size++] = elem;
        }
    }

    @Override
    public Iterator iterator() {
        return new EndlessArrayIterator<T>(this.data);
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnmodifiableCollection<?> that = (UnmodifiableCollection<?>) o;
        return size == that.size &&
                Arrays.equals(data, that.data);
    }
}
