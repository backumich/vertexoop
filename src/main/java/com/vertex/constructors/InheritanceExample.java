package com.vertex.constructors;

import lombok.experimental.var;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class InheritanceExample extends Parent{

    static List<String> myList2 = getStrings2();
    static List<String> myList;


    private List<String> field = getStrings3();

    private List<String> getStrings3() {
        val example = 7;
//        example = 12;
        System.out.println("init of the field");
        return Arrays.asList("1", "2");
    }

    {
        field = getStrings();
    }

    private static List<String> getStrings() {
        System.out.println("static block");
//        if(1==1){
//            throw new RuntimeException("in static block");
//        }
        return Arrays.asList("one", "two");
    }

    private static List<String> getStrings2() {
        System.out.println("static init");
        return Arrays.asList("one", "two");
    }

    public InheritanceExample(){
//        super("default");
        this("default");
//        this();
        System.out.println("In default child constructor");
    }

    public InheritanceExample(String name) {
        super(name);
        System.out.println("In parametrized child constructor with name: " + name);
    }

    public static void main(String[] args) {
        new InheritanceExample();
        new InheritanceExample("test");
    }
}
