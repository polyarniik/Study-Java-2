package ALGandDS;

import java.util.Arrays;

public class MergeSort {


    public static int[] sort(int[] array) {
        int n = array.length;
        if(array.length % 2 == 1) array = Arrays.copyOf(array, (int) Math.pow(2,log2(array.length)));
        for(int i = n; i < array.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        for (int size = 1; size < array.length; size *= 2) {
            for (int i = 0; i < array.length; i += size * 2) {
                int[] left = new int[size];
                int[] right = new int[size];
                for (int j = i; j < size + i; j++) {
                    left[j - i] = array[j];
                    right[j - i] = array[j + size];
                }
                int l = 0;
                int r = 0;
                for (int j = i; j < size * 2 + i; j++) {
                    if (l >= left.length) {
                        array[j] = right[r++];
                    } else if (r >= right.length) {
                        array[j] = left[l++];
                    } else if (left[l] < right[r]) {
                        array[j] = left[l++];
                    } else array[j] = right[r++];
                }
            }
        }
        return Arrays.copyOf(array, n);
    }

    private static int log2(int a) {
        int pow = (int) (Math.log(a)/Math.log(2));
        return pow % 2 == 0? pow: pow+1;
    }

    public static void main(String[] args) {
        int[] array = {23, 54, 43, 4, 27, 87, 3, 20, 13};
        System.out.println(Arrays.toString(sort(array)));
    }
}


