package homework.february.two.compareTo;

public class Crocodile implements Comparable<Crocodile> {
    public float length;
    public int old;
    public float weight;
    public int numberOfTooth;
    @Override
    public int compareTo(Crocodile c) {
        if(this.length == c.length) {
            if(this.old == c.old) {
                if(this.weight == c.weight) {
                    if (this.numberOfTooth == c.numberOfTooth) {
                        return 0;
                    }
                    else return this.numberOfTooth-c.numberOfTooth;
                }
                else return (int)(this.weight - c.weight);
            }
            else return this.old - c.old;
        }
        else return (int)(this.length-c.length);
    }
}
