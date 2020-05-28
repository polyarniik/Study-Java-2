package ALGandDS;

import java.util.Scanner;

public class KaratsubaWithoutBoolean {

    public static long multiply(long x, long y) {
        int size1 = getSize(x);
        int size2 = getSize(y);
        int N = Math.max(size1, size2);
        N = (N / 2) + (N % 2);
        long m = (long) Math.pow(10, N);
        long a = x / m;
        long b = x - (a * m);
        long c = y / m;
        long d = y - (c * N);
        long member1 = multiply(b, d);
        long member2 = multiply(b + a, d + c);
        long member3 = multiply(a, c);

        return member1 + ((member2 - member1 - member3) * m) + (member3 * (long) (Math.pow(10, 2 * N)));
    }

    public static int getSize(long num) {
        int size = 0;
        while (num != 0) {
            size++;
            num /= 10;
        }
        return size;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n1 = scan.nextLong();
        long n2 = scan.nextLong();
        System.out.println(multiply(n1, n2));
    }
}

