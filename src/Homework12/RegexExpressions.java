package Homework12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpressions {
    public static void main(String[] args) {
        Pattern pattern1 = Pattern.compile("^([a-zA-Z0-9.])+[a-zA-Z]");
        System.out.println(pattern1.matcher("java.second2020.ru").matches());
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher matcher1 = Pattern.compile("@[A-z0-9]+").matcher(s);
        Matcher matcher2 = Pattern.compile("[a-z0-9]+$").matcher(s);
        matcher1.find();
        matcher2.find();
        System.out.println(matcher1.group());
        System.out.println(matcher2.group());
    }
}
