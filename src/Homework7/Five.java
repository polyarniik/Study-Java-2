package Homework7;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Five {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 4, 54, 23, 34, 21, 41, 42));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(2, 543, 53,6 ,78, 776, 45, 46, 75, 64, 90, 59, 73, 3));
        arrayList2.stream()
                .filter(el -> el > Collections.max(arrayList1))
                .forEach(System.out::println);
    }
}
