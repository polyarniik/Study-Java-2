package collections.my;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.Object;
import java.util.Objects;


public class ModifiableCollection<T> extends AbstractCollection<T> {
    private T[] data;
    private int size;
    private int capacity;

    public ModifiableCollection() {
        this.capacity = 10;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public ModifiableCollection(ModifiableCollection<? extends T> coll) {
        this.data = (T[]) new Object[coll.size()];
        this.capacity = coll.size()*2;
        Iterator it = coll.iterator();
        size = 0;
        while (it.hasNext()){
            this.data[size++] = (T) it.next();
        }

    }

    @Override
    public boolean add(T t) {
        if(size + 1 == capacity) {
            this.capacity = this.capacity*2;
            data = Arrays.copyOf(data, capacity);
        }
        this.data[size++] = t;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifiableCollection<?> that = (ModifiableCollection<?>) o;
        return size == that.size &&
                capacity == that.capacity &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    private class BasicIterator implements Iterator {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return this.cursor < size;
        }

        @Override
        public T next() {
            return data[cursor++];
        }

        @Override
        public void remove() {
            for(int i = cursor; i  < size() -1; i++) {
                data[cursor] = data[cursor+1];
            }
            data[size()-1] = null;
        }
    }

    public static void main(String[] args) {
        ModifiableCollection<Integer> coll = new ModifiableCollection<>();
        System.out.println(coll.add(9));
        System.out.println(coll.iterator().next());
        System.out.println(coll.iterator().next());
        System.out.println(coll);
    }
}
