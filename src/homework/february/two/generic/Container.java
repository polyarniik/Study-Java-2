package homework.february.two.generic;

public class Container<T1 extends Comparable, T2 extends Comparable>{
    private final T1 obj1;
    private final T2 obj2;

    public Container(T1 obj1, T2 obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T1 getValue1() {
        return obj1;
    }

    public T2 getValue2() {
        return obj2;
    }

    public Class getType1() {return this.obj1.getClass(); }

    public Class getType2() { return this.obj2.getClass(); }
}