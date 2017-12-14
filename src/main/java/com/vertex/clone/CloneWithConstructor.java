package com.vertex.clone;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CloneWithConstructor {
    
    private int intField;
    private List<String> strings = new ArrayList<>();

    public CloneWithConstructor(){
        super();
    }
    
    public CloneWithConstructor(CloneWithConstructor other){
        this.intField = other.intField;
        this.strings = new ArrayList<>(other.strings);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CloneWithConstructor{");
        sb.append("intField=").append(intField);
        sb.append(", strings=").append(strings);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneWithConstructor withoutCloneable = getExampleObject();
        System.out.println(withoutCloneable);

        CloneWithConstructor cloned = new CloneWithConstructor(withoutCloneable);
        System.out.println(cloned);

        changeStrings(withoutCloneable, cloned);

        changeIntField(withoutCloneable, cloned);
    }

    private static void changeIntField(CloneWithConstructor withoutCloneable, CloneWithConstructor cloned) {
        cloned.setIntField(28);

        System.out.println("After we've changet int field");
        System.out.println(withoutCloneable);
        System.out.println(cloned);
    }

    private static void changeStrings(CloneWithConstructor withoutCloneable, CloneWithConstructor cloned) {
        cloned.getStrings().add("three");

        System.out.println("After we've added one more string to cloned");
        System.out.println(withoutCloneable);
        System.out.println(cloned);
    }

    private static CloneWithConstructor getExampleObject() {
        CloneWithConstructor withoutCloneable = new CloneWithConstructor();
        withoutCloneable.setIntField(32);
        withoutCloneable.getStrings().add("one");
        withoutCloneable.getStrings().add("two");
        return withoutCloneable;
    }
}
