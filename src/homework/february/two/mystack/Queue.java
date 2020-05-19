package homework.february.two.mystack;

import java.util.Objects;

public class Queue {
    private static final int CAPACITY = 1000;
    private int size = 0;
    private int start = 0;

    private static Object[] queue;

    public Queue() {
        queue = new Object[CAPACITY];
    }

    private void add(Object obj) {
        queue[size] = obj;
        size++;
    }

    private Object pop() {
        return queue[start++];
    }

    private Object peek() {return queue[start];}

    private int size() { return size-start; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return size == queue.size &&
                start == queue.start;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, start);
    }

    public static void main(String[] args) {
        Queue arr = new Queue();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        System.out.println(arr.pop());
        System.out.println(arr.peek());
        System.out.println(arr.size());
        System.out.println(arr.pop());
        System.out.println(arr.peek());
    }
}
