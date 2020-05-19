package homework.february.two.comparator;

import homework.february.two.compareTo.Smartphone;

import java.util.Comparator;

public class CameraDXoSmartphoneComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getCameraDXo()-o2.getCameraDXo();
    }
}
