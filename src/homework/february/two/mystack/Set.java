package homework.february.two.mystack;

import java.util.Arrays;

public class Set<T> {
    private int size;
    private T[] set;

    public Set() {
        this.size = 0;
        int INITIAL_CAPACITY = 1000;
        set = (T[]) new Object[INITIAL_CAPACITY];
    }

    public Set(int size) {
        this.size = 0;
        set = (T[]) new Object[size];
    }

    public boolean add(T obj) {
        for (int i = 0; i < size; i++) {
            if (set[i] == obj) return false;
        }
        set[size++] = obj;
        return true;
    }

    public boolean contains(T obj) {
        for (int i = 0; i < size; i++) {
            if (set[i] == obj) return true;
        }
        return false;
    }

    public int size() {
        return set.length;
    }

    public boolean remove(T obj) {
        for (int i = 0; i < size; i++) {
            if (set[i] == obj) {
                set[i] = null;
                for (int j = i; j < size -1; j++) {
                    set[j] = set[j + 1];
                }
                set[size -1]= null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(Set s) {
        int count = 0;
        if (this.size() != s.size()) return false;
        for (int i = 0; i < this.set.length; i++) {
            for (int j = 0; j < s.size(); j++) {
                if (this.set[i] == s.set[i]) {
                    count++;
                }
            }
        }
        if (count == s.size()) return true;
        else return false;
    }

    public Set merge(Set<Integer> s) {
        Set<T> newSet = new Set<>(this.size() + s.size());
        for (int i = 0; i < this.size(); i++) {
            newSet.add(this.set[i]);
        }
        for (int i = 0; i < s.size(); i++) {
            newSet.add((T) s.set[i]);
        }
        return newSet;
    }


    public static void main(String[] args) {
        Set<Integer> set1 = new Set<>(5);
        Set<Integer> set2 = new Set<>(5);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        System.out.println(Arrays.toString(set1.set));
        System.out.println(Arrays.toString(set2.set));
        Set<Integer> set3 = set1.merge(set2);
        System.out.println(Arrays.toString(set3.set));
        System.out.println(set1.remove(5));
        System.out.println(Arrays.toString(set1.set));
    }
}
