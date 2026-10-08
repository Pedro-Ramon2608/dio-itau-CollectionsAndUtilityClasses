package com.streamsapi;

import java.util.List;

public class MainStart {
    public static void main(String[] args) {
//        var value = Stream.of("Pedro", "Ramon", "Yasmin", "Francisco", "Eleazar", "Tomás", "Teresa", "Maria")
//                .filter(name -> name.contains("m"))
//                .limit(2)
//                .toList();
//
//        System.out.println(value); // Sem o .limit(2) = [Ramon, Yasmin, Tomás]
//
//        var value2 = Stream.of("Pedro", "Ramon", "Yasmin", "Francisco", "Eleazar", "Tomás", "Teresa", "Maria")
//                .anyMatch(name -> name.endsWith("ás")); // Retorna true ou false
//
//        System.out.println(value2);

//
//        var value3 = Stream.of("Pedro", "Ramon", "Yasmin", "Francisco", "Eleazar", "Tomás", "Teresa", "Maria")
//                .reduce("", (a, b) -> a + ";" + b).replaceFirst(";", "");
//
//        System.out.println(value3);

//
//        var value4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .map(n -> n % 2 == 0)
//                .toList();
//
//        System.out.println(value4);


        List<Integer> target = List.of(3, 5, 7, 9, 11);
        List<Integer> value = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

//        var valuesFilters = value.stream()
//                .filter(target::contains)
//                .toList();
//
//        System.out.println(valuesFilters);


        var valuesMap = value.stream()
                .filter(target::contains)
                .peek(n -> System.out.printf("Filter: %s\n", n))
                .map(n -> target.stream().reduce(n, Integer::sum))
                .peek(n -> System.out.printf("Map: %s\n", n))
                .toList();

        System.out.println(valuesMap);
    }
}
