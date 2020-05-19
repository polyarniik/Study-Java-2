package Homework7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Eight {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("123");
        arrayList.add("1234");
        arrayList.add("12345");
        arrayList.add("123456");
        arrayList.add("1234567");
        int length = arrayList.stream().
                filter(el -> el.length() > 5)
                .map(el -> el.length())
                .reduce(0, (len, a) -> len + a);
        System.out.println(length);
    }
}
