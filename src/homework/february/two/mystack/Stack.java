package homework.february.two.mystack;

public class Stack {

    private static final int CAPACITY = 1000;
    private int size = 0;

    private static Object[] stack;

    public Stack () {
        stack = new Object[CAPACITY];
    }

    public Stack(int size) {
        this.size = size;
        stack = new Object[size];
    }

    public void add(Object obj) {
        stack[size] = obj;
        size++;
    }

    public Object pop() {
        Object obj = stack[size-1];
        size--;
        return obj;
    }

    public Object peek() {return stack[size-1];}

    public int size() { return size; }



    public static void main(String[] args) {
        Stack arr = new Stack();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        System.out.println(arr.size());
        System.out.println(arr.pop());
        System.out.println(arr.peek());
        System.out.println(arr.size());
        System.out.println(arr.pop());
    }
}
