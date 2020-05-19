package homework.february.two.comparator;

public class BubbleSort {
    public static void sort(Comparable ... arr) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j]) > 0) {
                    Comparable a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;
                }
            }
        }
    }
}
