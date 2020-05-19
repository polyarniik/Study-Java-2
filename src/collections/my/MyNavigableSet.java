/**
 * @author Ruslan Safiullin
 * @version 1.0
 */

package collections.my;

import java.util.*;

public class MyNavigableSet<T> extends AbstractSet<T> implements NavigableSet<T> {
    private ArrayList<T> arrayList;
    private Comparator<T> comparator;

    /**
     * This is constructor with Collection<T>.
     */
    public MyNavigableSet(Collection<T> collection) {
        arrayList = (ArrayList<T>) collection;
    }

    /**
     *
     * @param comparator
     */
    public MyNavigableSet(Comparator<T> comparator) {
        this.comparator = comparator;
        arrayList = new ArrayList<>();
    }

    /**
     * This is constructor with Collection<T> and Comparator<T>.
     */
    public MyNavigableSet(Collection<T> collection, Comparator<T> comparator) {
        arrayList = (ArrayList<T>) collection;
        this.comparator = comparator;
    }

    /**
     * This method add element into Set.
     *
     * @param el
     * @return boolean
     */
    public boolean add(T el) {
        if (arrayList.indexOf(el) != -1) return false;
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(el, arrayList.get(i)) <= 0) {
                arrayList.add(i, el);
                return true;
            }
        }
        arrayList.add(el);
        return true;
    }

    /**
     * Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
     *
     * @param t
     * @return T
     */
    @Override
    public T lower(T t) {
        if (comparator.compare(t, first()) <= 0) return null;
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(t, arrayList.get(i)) < 0) return arrayList.get(i - 1);
        }
        return null;
    }

    /**
     * Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
     *
     * @param t
     * @return T
     */
    @Override
    public T floor(T t) {
        if (comparator.compare(t, first()) < 0) return null;
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(t, arrayList.get(i)) <= 0) return arrayList.get(i - 1);
        }
        return null;
    }
    /**
     * Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
     *
     * @param t
     * @return T
     */
    @Override
    public T ceiling(T t) {
        if (comparator.compare(t, last()) > 0) return null;
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(t, arrayList.get(i)) >= 0) return arrayList.get(i);
        }
        return null;
    }
    /**
     * Returns the least element in this set strictly greater than the given element, or null if there is no such element.
     * @param t
     * @return T
     */
    @Override
    public T higher(T t) {
        if (comparator.compare(t, last()) >= 0) return null;
        for (int i = 0; i < size(); i++) {
            if (comparator.compare(t, arrayList.get(i)) >= 0) return arrayList.get(i);
        }
        return null;
    }
    /**
     * Retrieves and removes the first (lowest) element, or returns null if this set is empty.
     *
     * @param
     * @return T
     */
    @Override
    public T pollFirst() {
        if (size() == 0) return null;
        T el = first();
        arrayList.remove(0);
        return el;
    }
    /**
     * Retrieves and removes the last (highest) element, or returns null if this set is empty.
     *
     * @param
     * @return T
     */
    @Override
    public T pollLast() {
        if (size() == 0) return null;
        T el = last();
        arrayList.remove(size() - 1);
        return el;
    }
    /**
     * Returns an iterator over the elements in this set.
     *
     * @param
     * @return Iterator<T>
     */
    @Override
    public Iterator<T> iterator() {
        return arrayList.iterator();
    }
    /**
     * Returns a reverse order view of the elements contained in this set.
     *
     * @param
     * @return NavigableSet<T>
     */
    @Override
    public NavigableSet<T> descendingSet() {
        ArrayList<T> descendingAL = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            descendingAL.add(arrayList.get(size() - i - 1));
        }
        return new MyNavigableSet<T>(descendingAL);
    }
    /**
     * Returns an iterator over the elements in this set, in descending order.
     *
     * @param
     * @return NavigableSet<T>
     */
    @Override
    public Iterator<T> descendingIterator() {
        ArrayList<T> descendingAL = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            descendingAL.add(arrayList.get(size() - i - 1));
        }
        return descendingAL.iterator();
    }
    /**
     * Returns a view of the portion of this set whose elements range from fromElement to toElement.
     *
     * @param fromElement, fromInclusive, toElement, toInclusive
     * @return NavigableSet<T>
     */
    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        return tailSet(fromElement, fromInclusive).headSet(toElement,toInclusive);
    }
    /**
     * Returns a view of the portion of this set whose elements are strictly less than toElement.
     *
     * @param toElement, inclusive
     * @return NavigableSet<T>
     */
    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        if (!inclusive) return (NavigableSet<T>) headSet(toElement);
        ArrayList<T> newArrayList = new ArrayList<>();
        for (T el : arrayList) {
            if (comparator.compare(el, toElement) <= 0) newArrayList.add(el);
        }
        return (NavigableSet<T>) newArrayList;
    }
    /**
     * Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
     *
     * @param fromElement
     * @return NavigableSet<T>
     */
    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        if (!inclusive) return (NavigableSet<T>) tailSet(fromElement);
        ArrayList<T> newArrayList = new ArrayList<>();
        for (T el : arrayList) {
            if (comparator.compare(el, fromElement) > 0) newArrayList.add(el);
        }
        return (NavigableSet<T>) newArrayList;
    }
    /**
     * Returns the comparator used to order the elements in this set, or null if this set uses the natural ordering of its elements.
     *
     * @param
     * @return boolean
     */
    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }
    /**
     * Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.
     *
     * @param fromElement
     * @return boolean
     */
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return headSet(toElement).tailSet(fromElement);
    }
    /**
     * Returns a view of the portion of this set whose elements are strictly less than toElement.
     *
     * @param toElement
     * @return SortedSet<T>
     */
    @Override
    public SortedSet<T> headSet(T toElement) {
        ArrayList<T> newArrayList = new ArrayList<>();
        for (T el : arrayList) {
            if (comparator.compare(el, toElement) < 0) newArrayList.add(el);
        }
        return (SortedSet<T>) newArrayList;
    }
    /**
     * Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
     *
     * @param fromElement
     * @return SortedSet<T>
     */
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        ArrayList<T> newArrayList = new ArrayList<>();
        for (T el : arrayList) {
            if (comparator.compare(el, fromElement) > 0) newArrayList.add(el);
        }
        return (SortedSet<T>) newArrayList;
    }
    /**
     * Returns the first (lowest) element currently in this set.
     *
     * @param
     * @return T
     */
    @Override
    public T first() {
        return arrayList.get(0);
    }
    /**
     * Returns the last (highest) element currently in this set.
     *
     * @param
     * @return T
     */
    @Override
    public T last() {
        return arrayList.get(size() - 1);
    }
    /**
     * Returns the number of elements in this NavigableSet.
     *
     * @param
     * @return int
     */
    @Override
    public int size() {
        return arrayList.size();
    }
}
