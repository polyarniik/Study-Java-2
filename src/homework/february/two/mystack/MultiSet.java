package homework.february.two.mystack;

public class MultiSet<T>  {
    private T[] set;
    private int[] number;
    private int index;


    public MultiSet() {
        int INITIAL_CAPACITY = 1000;
        this.index = 0;
        set = (T[]) new Object[INITIAL_CAPACITY];
        number = new int[INITIAL_CAPACITY];
    }

    public boolean contains(T el) {
        for(T x: set) {
            if(el == x) return true;
        }
        return false;
    }

    public boolean add(T el) {
        if(!contains(el)) {
            set[index++] = el;
        }
        for(int i = 0; i < index; i++) {
            if(el == set[i]) {
                number[i]++;
                return true;
            }
        }
        return false;
    }

    public boolean remove(T el) {
        if(!contains(el)) return false;
        for (int i = 0; i < index; i++) {
            if (set[i] == el) {
                number[i]--;
                if (number[i] == 0) {
                    set[i] = null;
                    for (int j = i; j < index; j++) {
                        set[j] = set[j + 1];
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean contains(MultiSet s) {
        int count = 0;
        if(set.length != s.size()) return false;
        for(int i = 0; i < this.set.length; i++) {
            for(int j = 0; j < s.size(); j++) {
                if(this.set[i] == s.set[i]) {
                    count++;
                }
            }
        }
        if (count == s.size()) return true;
        else return false;
    }

    public int size() {
        return index;
    }
}
