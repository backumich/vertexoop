package com.vertex.clone;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

public class Cat implements Serializable {

    private String name;
    private List<String> colors = new ArrayList<>();
    private int age;

    Cat(String name, List<String> colors, int age) {
        this.name = name;
        this.colors.addAll(colors);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' +
                ", colors='" + colors + '\'' +
                ", age=" + age +
                '}';
    }
}

class BasketCats {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat vaska = new Cat("Vaska", singletonList("Gray"), 4);

        byte[] serializedCat = serializeCat(vaska);
        System.out.println(new String(serializedCat));

        Cat cloneVaska = deserializeCat(serializedCat);

        System.out.println(vaska);
        System.out.println(cloneVaska);
        System.out.println("*********************************************");
        cloneVaska.getColors().add("Black");
        System.out.println(vaska);
        System.out.println(cloneVaska);

    }

    private static Cat deserializeCat(byte[] serializedCat) throws IOException, ClassNotFoundException {
        Cat toReturn;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedCat);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            toReturn = (Cat) ois.readObject();
        }
        return toReturn;
    }

    private static byte[] serializeCat(Cat vaska) throws IOException {
        byte[] serializedCat;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream ous = new ObjectOutputStream(baos)) {
            ous.writeObject(vaska);
            serializedCat = baos.toByteArray();
        }
        return serializedCat;
    }
}
