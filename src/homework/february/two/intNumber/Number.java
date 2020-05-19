package homework.february.two.intNumber;

public interface Number<T extends Number<T>> {

    public T add(T o1, T o2);
    public T subtract(T o1, T o2);
    public T multiply(T o1, T o2);

}


