package com.vertex.constructors;

import java.util.Arrays;
import java.util.List;

public class Parent {

    static List<String> myList2 = getStrings2();
    static List<String> myList;

    static {
        myList = getStrings();
    }

    private String name;
    private List<String> field = getStrings3();


    private List<String> getStrings3() {
        System.out.println("init of the Parent field");
        return Arrays.asList("1", "2");
    }

    private static List<String> getStrings2() {
        System.out.println("init Parent static var");
        return null;
    }

    private static List<String> getStrings() {
        System.out.println("Static parent block");
        return null;
    }

    public Parent(){
        System.out.println("in default Parent constructor");
    }

    public Parent(String name){
        this.name = name;
        System.out.println("Name for parent: " + this.name);
    }
}
