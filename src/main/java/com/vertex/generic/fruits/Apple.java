package com.vertex.generic.fruits;

import com.vertex.compare.AppleSweetnessComparator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple implements Fruit, Comparable<Apple> {

    private double weight;
    private double sweetness;

    @Override
    public String squeeze() {
        return "Apple juice";
    }

    @Override
    public int compareTo(Apple other) {
        return this.weight > other.weight ? 1 : this.weight == other.weight ? 0 : -1;
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple(3.0, 1.0);
        Apple apple2 = new Apple(2.0, 5.0);
        Apple apple3 = new Apple(8.0, 3.0);
        Apple apple4 = new Apple(1.0, 2.0);
        Apple apple5 = new Apple(4.0, 8.0);
        Apple apple6 = new Apple(15.0, 3.0);


        List<Apple> apples = Arrays.asList(apple1, apple2, apple3, apple4, apple5, apple6);
        System.out.println(apples);

        Collections.sort(apples);
        System.out.println(apples);

        apples.sort(new AppleSweetnessComparator()
                .reversed());
        System.out.println(apples);
    }

}
