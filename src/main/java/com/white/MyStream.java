package com.white;

import java.util.ArrayList;
import java.util.List;

public class MyStream {
    public static void main(String[] args) {
        List<A> list=new ArrayList<A>();
        list.add(new A(1));
        list.add(new A(2));
        list.add(new A(3));

        int value = list.stream().map(x -> x.getA()).reduce(0, (a, b) -> a + b);
        System.out.println(value);
    }
}

class A {
    public int a;

    public int getA(){
        return a;
    }

    A(int value) {
        a = value;
    }
}
