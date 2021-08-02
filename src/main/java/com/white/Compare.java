package com.white;

public class Compare {
    public static void main(String[] args) {
        String a = "test";
        a = new String("new Str");
        transfer(a);
        System.out.println(a);

        Integer b = 456;
        transferInteger(b);
        System.out.println(b);
    }

    public static void transfer(String b) {
        b = "123";
    }

    public static void transferInteger(Integer b) {
        b = 123;
    }
}
