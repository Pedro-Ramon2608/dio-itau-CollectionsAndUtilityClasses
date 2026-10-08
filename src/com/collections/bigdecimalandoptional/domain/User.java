package com.collections.bigdecimalandoptional.domain;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private ClassEnumSex sex;

    public User(String name, int age, ClassEnumSex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User { " +
                "name = '" + name + '\'' +
                " | age = " + age +
                " | sex = " + sex +
                " }";
    }
}
