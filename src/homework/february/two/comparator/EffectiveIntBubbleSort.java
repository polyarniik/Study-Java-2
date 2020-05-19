package homework.february.two.comparator;

public class EffectiveIntBubbleSort {
    public static void sort(int ... e){
        for(int i = 0; i < e.length-1; i++) {
            int count = 0;
            for(int j = i+1; j < e.length; j++) {
                if(e[i] > e[j]) {
                    int a = e[i];
                    e[i] = e[j];
                    e[j] = a;
                }
            }
            if(count == 0) i=e.length;
        }
    }
}
