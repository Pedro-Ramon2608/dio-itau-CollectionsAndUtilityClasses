package com.collections.arraylistsetmap;

import java.util.ArrayList;
import java.util.List;

public class ListAndArrayList {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User user = new User(1, "Jesus", 33);

        users.add(user);
        users.add(new User(2, "Pedro", 19));
        users.add(new User(3, "Yasmin", 19));
        users.add(new User(4, "Pamela", 32));

//        System.out.println(users.contains(user));
//        System.out.println(users.contains(new User(1, "Jesus", 33)));

//        System.out.println(users.getFirst());
//        System.out.println(users.getLast());
//        System.out.println(users.get(2));

        users.forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        users.remove(1);
        users.forEach(System.out::println);
    }

}
