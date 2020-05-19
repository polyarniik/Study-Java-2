package homework.february.two.compareTo;

import homework.february.two.comparator.PowerSmartphoneComparator;

import java.util.Arrays;
import java.util.Objects;

import static homework.february.two.comparator.BubbleSort.sort;

public class Smartphone implements Comparable<Smartphone>{
    public float power;
    public int cameraDXo;
    public int battery;
    public boolean NFC;


    public Smartphone(float power, int cameraDXo, int battery, boolean NFC) {
        this.power = power;
        this.cameraDXo = cameraDXo;
        this.battery = battery;
        this.NFC = NFC;
    }

    @Override
    public int compareTo(Smartphone s) {
        if(this.power == s.power) {
            if(this.cameraDXo == this.cameraDXo) {
                if(this.battery == s.battery) {
                    if(this.NFC == s.NFC) {
                        return 0;
                    }
                    else return -1;
                }
                else return this.battery - s.battery;
            }
            else return this.cameraDXo - s.cameraDXo;
        }
        else return (int)(this.power-s.power);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return Float.compare(that.power, power) == 0 &&
                cameraDXo == that.cameraDXo &&
                battery == that.battery &&
                NFC == that.NFC;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "power=" + power +
                ", cameraDXo=" + cameraDXo +
                ", battery=" + battery +
                ", NFC=" + NFC +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, cameraDXo, battery, NFC);
    }

    public float getPower() {
        return power;
    }

    public int getCameraDXo() {
        return cameraDXo;
    }

    public int getBattery() {
        return battery;
    }

    public boolean isNFC() {
        return NFC;
    }





    public static void main(String[] args) {
        Smartphone s1 = new Smartphone(100, 93, 4000, true);
        Smartphone s2 = new Smartphone(100, 93, 4050, true);
        Smartphone s3 = new Smartphone(90, 93, 4000, false);
        Smartphone[] sm = {s1, s2, s3};
        System.out.println(s1.compareTo(s2));
        sort(sm);
        PowerSmartphoneComparator comparePower = new PowerSmartphoneComparator();
        System.out.println(comparePower.compare(s1, s3));
        for( int i = 0; i < sm.length; i++) {
            System.out.println(sm[i]);
        }
    }
}
