package com.vertex.compare;

import com.vertex.generic.fruits.Apple;

import java.util.Comparator;

public class AppleSweetnessComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return Double.compare(o1.getSweetness(), o2.getSweetness());
    }
}
