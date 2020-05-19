package homework.february.two.generic;

import java.util.Objects;

public class Pair<T1, T2> {
    private T1 firstElem;
    private T2 secondElem;

    public Pair(T1 obj1, T2 obj2) {
        this.firstElem = obj1;
        this.secondElem = obj2;
    }

    public T1 getFirstElem() {
        return firstElem;
    }

    public T2 getSecondElem() {
        return secondElem;
    }

    public void setFirstElem(T1 elem) {
        firstElem = elem;
    }

    public void setSecondElem(T2 elem) {
        secondElem = elem;
    }

    public Class getFirstType() { return firstElem.getClass(); }

    public Class getSecondType() {
        return secondElem.getClass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(firstElem, pair.firstElem) &&
                Objects.equals(secondElem, pair.secondElem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElem, secondElem);
    }
}

