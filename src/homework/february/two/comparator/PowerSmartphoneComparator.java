package homework.february.two.comparator;

import homework.february.two.compareTo.Smartphone;

import java.util.Comparator;

public class PowerSmartphoneComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return (int) (o1.getPower() - o2.getPower());
    }
}
