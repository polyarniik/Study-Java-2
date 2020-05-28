package ALGandDS;

import java.util.Arrays;

public class MergeSortRecursion {
    public static void main(String[] args) {
        int[] array = {23, 54, 43, 4, 27, 87, 3, 20, 13};
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        int n = array.length;
        if(n < 2) return array;
        int middle = n / 2;
        int[] left = sort(Arrays.copyOf(array, middle));
        int[] right = sort(Arrays.copyOfRange(array, middle, n));
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < result.length; i++) {
            if(l >= left.length) {
                result[i] = right[r++];
            }
            else if (r >= right.length) {
                result[i] = left[l++];
            }
            else if(left[l] < right[r]) {
                result[i] = left[l++];
            } else result[i] = right[r++];
        }
        return result;
    }
}
