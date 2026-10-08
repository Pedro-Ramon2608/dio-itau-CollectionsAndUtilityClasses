package com.collections.arraylistsetmap;

import java.util.HashSet;
import java.util.Set;

public class ListSet {
    public static void main(String[] args) {
        Set<User> usersSet = new HashSet<>();

        usersSet.add(new User(1, "Jesus", 33));
        usersSet.add(new User(2, "Pedro", 19));
        usersSet.add(new User(3, "Yasmin", 19));
        usersSet.add(new User(4, "Pamela", 32));

        System.out.println(usersSet);

        System.out.println(usersSet.hashCode());

        // return false if in class User haven't method hashCode
        System.out.println(usersSet.contains(new User(1, "Jesus", 33)));

        var iterator = usersSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
