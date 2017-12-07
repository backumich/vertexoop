package com.vertex.inner;

import java.util.*;

public class InnerExample {

    public class NestedClass{ }
    private static class NestedStaticClass{ }
    public enum NestedEnum{ ONE }

    public NestedClass getNestedClass(){
        return new NestedClass();
    }


    public void method(){
        class InnerClass{ }

        InnerClass innerClass = new InnerClass();

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        List<String> list = new ArrayList<String>() {
//            @Override
//            public String get(int index) {
//                return null;
//            }

            @Override
            public int size() {
                return 777;
            }
        };

        list.size();
     }

    public static void main(String[] args) {
        InnerExample.NestedStaticClass aClass = new InnerExample.NestedStaticClass();
        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>("","");

        InnerExample innerExample = new InnerExample();
        innerExample.method();
//        innerExample.NestedClass nestedClass = new NestedClass();
    }

}
class SecondClass {

}
