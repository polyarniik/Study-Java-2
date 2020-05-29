package ALGandDS;

import java.util.Scanner;

public class KaratsubaWithoutBoolean {

    public static long multiply(long x, long y) {
        int size1 = Long.toString(x).length();
        int size2 = Long.toString(y).length();
        int n = Math.max(size1, size2);
        if (n < 3) return x * y;
        n = (n / 2) + (n % 2);
        long m = (long) Math.pow(10, n);
        long a = x / m;
        long b = x % m;
        long c = y / m;
        long d = y % m;
        long member1 = multiply(a, c);
        long member2 = multiply(a + b, c + d);
        long member3 = multiply(b, d);
        return member1*m*m + (member2 - member1 - member3)*m + member3;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n1 = scan.nextLong();
        long n2 = scan.nextLong();
        System.out.println(multiply(n1, n2));
    }
}

