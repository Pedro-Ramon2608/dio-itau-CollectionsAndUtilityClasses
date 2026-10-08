package com.exception.validator;

import com.exception.exception.ValidatorException;
import com.exception.model.UserModel;

public class UserValidator {


    private UserValidator() {

    }

    public static void verifyModel(final UserModel userModel) throws ValidatorException {
        if (stringIsBlank(userModel.getName()))
            throw new ValidatorException("Informe um nome válido.");
        if (userModel.getName().length() < 3)
            throw new ValidatorException("O nome deve ter no minimo 3 caracteres.");
        if (emailValidator(userModel.getEmail()))
            throw new ValidatorException("Informe um email válido.");

    }

    private static boolean stringIsBlank(final String value) {
        return value == null || value.isBlank();
    }

    private static boolean emailValidator(final String value) {
        return value == null || value.isBlank() || !value.contains("@") || !value.contains(".");
    }
}
