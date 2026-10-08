package com.collections.bigdecimalandoptional;

import static com.collections.bigdecimalandoptional.domain.ClassEnumSex.MAN;
import static com.collections.bigdecimalandoptional.domain.ClassEnumSex.OTHER;

import com.collections.bigdecimalandoptional.domain.User;

import java.util.Optional;

public class MainOptional {
    public static void main(String[] args) {
        //Optional<User> optionalUser = Optional.of(new User("Pedro", 19, MAN));
        Optional<User> optionalUser = Optional.empty();

        // o .get() gera uma exceção se o Optional estiver vazio
        // System.out.println(optionalUser.get());

        // Para realizar o print do dado sem correr o risco dele estar vazio e gerar uma exceção é bom usar
        // o .orElse(), que você cria um default caso o Optional esteja vazio e não quebra o programa
        System.out.println(optionalUser.orElse(new User("Default", 0, OTHER)));
    }
}
