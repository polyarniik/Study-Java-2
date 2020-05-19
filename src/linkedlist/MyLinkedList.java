package linkedlist;

import java.util.Arrays;
import java.util.Objects;

public class MyLinkedList<T> {

    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll.size());
        System.out.println(ll.get(1));
        System.out.println(ll.remove(2));
        System.out.println(ll.get(2));
        System.out.println(ll.size);
    }

    private Node<T> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T el) {
        if (head == null) {
            head = new Node<>(el);
            size++;
            return;
        }
        Node<T> count = head;
        for (int i = 0; i < size-1; i++) {
            count = count.getNext();
        }
        count.setNext(new Node<>(el));
        size++;
    }

    public void addAfter(T el, int index) {
        if (index >= size) throw new NullPointerException();
        Node<T> count = head;
        for (int i = 0; i < index; i++) {
        }
        size++;
    }

    public void addFirst(T el) {
        Node<T> n = new Node<>(el, head);
        head = n;
        size++;
    }


    public T get(int index) {
        Node<T> n = head;
        if (index >= size) return null;
        for (int j = 0; j < index; j++) {
            n = n.getNext();
        }
        return n.getValue();
    }

    public boolean remove(T el) {
        Node<T> count = head;
        if(count.next != null) size--;
        while (count.next != null) {
            //to do with setNext;
            if(count.next.value == el){
                count.setNext(count.next.next);
                return true;
            }
            count = null;
        }
        return false;
    }


    public boolean remove(int index) {
        if(index > size) return false;
        Node<T> count = head;
        for(int i = 0; i < index-1; i++) {
            count = count.next;
        }
        count.setNext(count.next.next);
        return true;
    }

    public void merge(MyLinkedList<T> list) {
        add(list.getHead().value);
    }

    public int indexOf(T el){
        Node<T> count = head;
        for(int i = 0; i < size; i++) {
            if(count.value == el){
                return i;
            }
            count = count.next;
        }
        return -1;
    }

    public int size() {
        return size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size &&
                Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    public Node<T> getHead() {
        return head;
    }

    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;

        }

        public Node(T el) {
            this.value = el;
            this.next = null;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }
    }
}
