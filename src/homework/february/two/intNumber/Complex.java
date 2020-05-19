package homework.february.two.intNumber;

public class Complex implements Number<Complex> {
    private int r;
    private int i;

    public Complex(int r, int i) {
        this.r = r;
        this.i = i;
    }

    @Override
    public Complex add(Complex o1, Complex o2) {
        return new Complex(o1.r + o2.r, o1.i + o2.i);
    }

    @Override
    public Complex subtract(Complex o1, Complex o2) {
        return new Complex(o1.r - o2.r, o1.i - o2.i);
    }

    @Override
    public Complex multiply(Complex o1, Complex o2) {
        return new Complex(o1.r*o2.r - o1.i*o2.i, o1.i*o2.r + o1.r*o2.i);
    }

    public int getR() {
        return r;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Complex{" +
                " " + r +
                i + "*i"+
                '}';
    }
}
