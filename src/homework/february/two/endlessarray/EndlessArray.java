package homework.february.two.endlessarray;

/**
 * @author Ruslan Safiullin
 * @version 1.0
 */

import collections.iterator.EndlessArrayIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public class EndlessArray<T> implements Iterable<T> {
    private T[] array;
    private int size;

    /**
     * This is constructor without parameters.
     */
    public EndlessArray() {
        array = (T[]) new Object[2];
        size = 0;
    }

    /**
     * This is constructor with initial size.
     *
     * @param arraySize
     */
    public EndlessArray(int arraySize) {
        array = (T[]) new Object[arraySize];
        size = 0;
    }


    /**
     * This is constructor which accept array.
     *
     * @param newArray
     */
    public EndlessArray(T[] newArray) {
        array = newArray;
        size = array.length;
    }

    /**
     * This method return index of specified element.
     *
     * @param n
     * @return i, index.
     */
    public int indexOf(T n) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(n))
                return i;
        }
        return -1;
    }

    /**
     * This method give size of array.
     *
     * @return array Size;
     */
    public int getSize() {
        return size;
    }

    /**
     * This method remove element from specified element.
     *
     * @param i
     * @throws BoundOfIndexExceptions
     */
    public void remove(int i) throws BoundOfIndexExceptions {
        if (i < size) {
            if (size - 1 - i >= 0) System.arraycopy(array, i + 1, array, i, size - 1 - i);
            size--;
            narrowArray();
        } else throw new BoundOfIndexExceptions("Exception");
    }

    /**
     * This method narrow array.
     */
    public void narrowArray() {
        T[] newArray = (T[]) new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        array = newArray;
    }

    /**
     * This method return element with specified index.
     *
     * @param i
     * @return
     * @throws BoundOfIndexExceptions
     */
    public T get(int i) throws BoundOfIndexExceptions {
        if (i < size) return (array[i]);
        else throw new BoundOfIndexExceptions("-1");
    }

    /**
     * This method add element in array.
     *
     * @param n
     */
    public void add(T n) {
        if (size == array.length) extendArray();
        array[size] = n;
        size++;
    }

    /**
     * This method extend array.
     */
    public void extendArray() {
        T[] newArray = (T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new EndlessArrayIterator<T>(array);
    }

    /**
     * Compare this EA with specified index.
     *
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndlessArray<?> that = (EndlessArray<?>) o;
        return size == that.size &&
                Arrays.equals(array, that.array);
    }

    /**
     * Hashcode for this EA.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    /**
     * String representation of the EA.
     *
     * @return
     */
    @Override
    public String toString() {
        return "EndlessArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        EndlessArray<Integer> arr = new EndlessArray<>();
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(new Integer(5));
        System.out.println(arr.toString());
    }

}
