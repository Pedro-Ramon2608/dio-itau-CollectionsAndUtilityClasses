package com.collections.arraylistsetmap;


import java.util.HashMap;
import java.util.Map;

public class MapHashMap {
    public static void main(String[] args) {
        Map<Integer, User> users = new HashMap<>();

        users.put(1, new User(1, "Pedro", 14));
        users.put(2, new User(2, "Ramon", 5));
        users.put(3, new User(3, "Yasmin", 21));
        users.put(4, new User(4, "Francisco", 52));
        users.put(5, new User(5, "Tomás", 31));
        users.put(6, new User(6, "Teresa", 7));
        users.put(7, new User(7, "Maria", 44));

//        users.keySet().forEach(System.out::println);
//        System.out.println("====================================");
//        users.values().forEach(System.out::println);

//        System.out.println(users.get(4));

//        System.out.println(users.containsKey(2));
//        System.out.println(users.containsValue(new User(1, "Pedro ", 14)));

        System.out.println(users);
        System.out.println("====================================");

        // Funciona como um replace bem bonito e integente
        // user é o antigo que já estava no Map e user2 é o novo valor: "new User(4, "Francisco Eleazar", 67"
        users.merge(4, new User(4, "Francisco Eleazar", 67), (user, user2) -> user2);

//        System.out.println("====================================");
        System.out.println(users);
    }
}
