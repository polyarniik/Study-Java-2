package collections.my;


import org.omg.CORBA.Object;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;


public class ModifiableCollection<T> extends AbstractCollection<T> {
    private T[] data;
    private int size;

    public ModifiableCollection() {
        this.data = (T[]) new Object[0];
        this.size = data.length;
    }

    public ModifiableCollection(ModifiableCollection<? extends T> coll) {
        this.data = (T[]) new Object[coll.size()];
        Iterator<T> it = (Iterator<T>) coll.iterator();
        size = 0;
        for (T elem : coll) {
            data[size++] = elem;
        }

    }

    @Override
    public boolean add(T t) {
        if(size >= size()) {
            data = Arrays.copyOf(data, size()*2);
        }
        data[size++] = t;
        return true;
    }

    @Override
    public Iterator iterator() {
        return new BasicIterator();
    }


    @Override
    public int size() {
        return data.length;
    }

    private class BasicIterator<T> implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            return (T) data[cursor++];
        }

        @Override
        public void remove() {
            for(int i = cursor; i  < size() -1; i++) {
                data[cursor] = data[cursor+1];
            }
            data[size()-1] = null;
        }
    }
}
