package com.streamsapi;

import com.streamsapi.domain.Contact;
import com.streamsapi.domain.ContactType;
import com.streamsapi.domain.Sex;
import com.streamsapi.domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainEnd {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUsers());

//        users.sort(Comparator.comparing(User::name));

//        users.forEach(System.out::println);

//        var value = users.stream()
//                .flatMap(user -> user.contacts().stream())
//                .sorted(Comparator.comparing(Contact::description))
//                .map(c -> String.format("{\n    'description': %s,\n    'type': %s \n}", c.description(),
//                        c.contactType()))
//                .toList();

//        var value = users.stream()
//                .sorted(Comparator.comparing(User::name))
//                .map(MainEnd::formatedUsers)
//                .toList();

//        value.forEach(System.out::println);
    }


    private static String formatedUsers(User u) {
        var contact = u.contacts().stream()
                .map(c -> String.format("{\n        'description': %s,\n        'type': %s \n    }",
                        c.description(), c.contactType()))
                .toList();

        return String.format("""
                            {
                                'name': '%s',
                                'age': '%s',
                                'sex': '%s'
                                'contacts':
                                %s
                            }
                            """, u.name(), u.age(), u.sex(), contact);
    }


    private static List<User> generateUsers() {
        var contact1 = List.of(
                new Contact("(14) 92286-2121", ContactType.PHONE),
                new Contact("pedro@gmail.com", ContactType.EMAIL)
        );

        var contact2 = List.of(
                new Contact("ramon@outlook.com", ContactType.EMAIL)
        );

        var contact3 = List.of(
                new Contact("(17) 91212-1921", ContactType.PHONE)
        );

        var contact4 = List.of(
                new Contact("(21) 91234-8765", ContactType.PHONE),
                new Contact("(12) 94758-3214", ContactType.PHONE)
        );

        var contact5 = List.of(
                new Contact("marcia@gmail.com", ContactType.EMAIL),
                new Contact("marcia123@hotmart.com", ContactType.EMAIL)
        );


        var user1 = new User("Pedro", 19, Sex.MAN, new ArrayList<>(contact1));

        var user2 = new User("Ramon", 31, Sex.MAN, new ArrayList<>(contact2));

        var user3 = new User("Yasmin", 21, Sex.WOMAN, new ArrayList<>(contact3));

        var user4 = new User("Juselino", 50, Sex.MAN, new ArrayList<>(contact4));

        var user5 = new User("Marcia", 36, Sex.WOMAN, new ArrayList<>(contact5));

        var user6 = new User("Habacuque", 87, Sex.MAN, new ArrayList<>());

        return List.of(user1, user2, user3, user4, user5, user6);
    }
}
