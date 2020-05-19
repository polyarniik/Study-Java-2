package Homework7;

import java.util.Comparator;

public class Four {

    private static class Smartphone {
        private  int antutu;

        public Smartphone(int antutu) {
            this.antutu = antutu;
        }

        public int getAntutu(){
            return this.antutu;
        }
    }

    public static void main(String[] args) {
        Smartphone ph1 = new Smartphone(400000);
        Smartphone ph2 = new Smartphone(250000);

        Comparator<Smartphone> antutuComp =
                (Smartphone p1, Smartphone p2) -> p1.getAntutu() - p2.getAntutu();
        System.out.println(antutuComp.compare(ph1, ph2));
    }
}
