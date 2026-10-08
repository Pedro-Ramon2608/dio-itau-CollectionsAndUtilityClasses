package com.collections.arraylistsetmap;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;

        if (obj instanceof User user) {
            if (this == user) isEquals = true;
            if (this.id == user.id && this.name.equals(user.name) && this.age == user.age) isEquals = true;
        }

        return isEquals;
    }


    @Override
    public String toString() {
        return String.format("{'id': %s, 'name': %s, 'age': %s}", this.id,this. name, this.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
