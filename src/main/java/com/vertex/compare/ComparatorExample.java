package com.vertex.compare;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
class User {
    private String name;
    private int age;
}

public class ComparatorExample{
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
//                new IoUser(null, 35), //generates NullPointerException
                new User("Alex", 21));

        //sorting by Name
        users.sort(Comparator.comparing(User::getName));

        //sorting by name and by age
        users.sort(Comparator.comparing(User::getName)
                .thenComparing(User::getAge));


        System.out.println(users);
    }
}
