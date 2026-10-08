package com.exception.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class UserModel {
    private long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UserModel() {
    }

    public UserModel(long id, String name, String email, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = birth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return dateOfBirth;
    }

    public void setBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return id == userModel.id &&
                Objects.equals(name, userModel.name) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(dateOfBirth, userModel.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, dateOfBirth);
    }

    @Override
    public String toString() {
        return String.format("""
                User {
                    'id': '%s'
                    'name': '%s'
                    'email': '%s'
                    'dateOfBirth': '%s'
                }""", id,  name, email, dateOfBirth.format(formatter));
    }
}
