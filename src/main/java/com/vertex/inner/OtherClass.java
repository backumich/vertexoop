package com.vertex.inner;

public class OtherClass {

    public void useNested(InnerExample example){
        InnerExample.NestedClass nestedClass = example.getNestedClass();
    }

    public static void main(String[] args) {

    }
}
