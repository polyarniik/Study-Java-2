package Homework7;

import java.util.HashSet;
import java.util.Set;

public class Six {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("1234");
        set.add("12");
        set.add("1");
        set.add("12345");
        set.stream().
                filter(elem -> (elem.length() > 3))
                .forEach(System.out::println);
    }
}
