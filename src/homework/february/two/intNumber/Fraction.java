package homework.february.two.intNumber;

public class Fraction implements Number<Fraction> {

    private int nom;
    private int denom;

    public Fraction(int nom, int denom) {
        this.nom = nom;
        this.denom = denom;
    }

    @Override
    public Fraction add(Fraction o1, Fraction o2) {
        return new Fraction(o1.nom*o2.denom + o2.nom*o1.denom, o1.denom*o2.denom);
    }

    @Override
    public Fraction subtract(Fraction o1, Fraction o2) {
        return new Fraction(o1.nom*o2.denom, o1.denom*o2.nom);
    }

    @Override
    public Fraction multiply(Fraction o1, Fraction o2) {
        return new Fraction(o1.nom*o2.nom, o1.denom*o2.denom);
    }

    private Fraction reduction(Fraction f) {
        int a = gcd(f.nom, f.denom);
        return new Fraction(f.nom/a, f.denom/a);
    }

    private int gcd (int a, int b) {
        if(b==0) return Math.abs(a);
        return gcd(b, a%b);
    }

    public int getNom() {
        return nom;
    }

    public int getDenom() {
        return denom;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                nom +
                "/(" + denom +
                ")}";
    }
}
