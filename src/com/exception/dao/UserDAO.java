package com.exception.dao;

import com.exception.exception.EmptyStoreException;
import com.exception.exception.UserNotFoundException;
import com.exception.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private long nextId = 1L;
    private final List<UserModel> users = new ArrayList<>();


    public UserModel create(UserModel userModel) {
        userModel.setId(nextId++);
        users.add(userModel);
        return userModel;
    }

    public UserModel update(UserModel userModel) {
        var toUpdate = findById(userModel.getId());
        users.remove(toUpdate);
        users.add(userModel);

        return userModel;
    }

    public void delete(long id) {
        var toDelete = findById(id);
        users.remove(toDelete);
    }

    public UserModel findById(long id) {
        verifyStorage();
        var message = String.format("Usuário com id %s não encontrado.", id);

        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }

    public List<UserModel> findAll() {
        List<UserModel> users;
        try {
            verifyStorage();
            users = this.users;
        } catch (EmptyStoreException e) {
            e.printStackTrace();
            users = new ArrayList<>();
        }
        return users;
    }

    private void verifyStorage() {
        if (users.isEmpty()) throw new EmptyStoreException("O armazenamento está vazio. Não existe nenhum " +
                "usuário cadastrado.");
    }
}
