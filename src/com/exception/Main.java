package com.exception;

import com.exception.dao.UserDAO;
import com.exception.exception.CustomException;
import com.exception.exception.EmptyStoreException;
import com.exception.exception.UserNotFoundException;
import com.exception.exception.ValidatorException;
import com.exception.model.MenuOption;
import com.exception.model.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.exception.validator.UserValidator.verifyModel;

public class Main {
    private final static UserDAO dao = new UserDAO();
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("---> Bem-vindo ao cadastro de usuários <---");

        while (true) {
            var inputOptionUser = menu();
            var selectedOption = MenuOption.values()[inputOptionUser - 1];

            switch (selectedOption) {
                case CREATE -> {
                    try {
                        var user = dao.create(requestToCreateUser());
                        System.out.printf("\nUsuário %s, criado com sucesso!\n\n", user.getName());
                    } catch (CustomException ex) {
                        ex.printStackTrace();
                        System.out.println("\n" + ex.getMessage() + "\n");

                    }
                }
                case UPDATE -> {
                    try {
                        var user = dao.update(requestToUpdateUser());
                        System.out.printf("\nUsuário %s, atualizado com sucesso!\n\n", user.getName());
                    } catch (UserNotFoundException | EmptyStoreException e) {
                        System.out.println(e.getMessage());
                    } catch (CustomException ex) {
                        ex.printStackTrace();
                        System.out.println("\n" + ex.getMessage() + "\n");
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestUserId());
                        System.out.println("\nUsuário excluido.\n");
                    } catch (UserNotFoundException | EmptyStoreException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestUserId();
                        var user = dao.findById(id);
                        System.out.printf("\nUsuário do id %d", id);
                        System.out.println(user + "\n");
                    } catch (UserNotFoundException | EmptyStoreException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("\n---> Usuários Cadastrados <---");
                    users.forEach(System.out::println);
                    System.out.println("-".repeat(30) + "\n");
                }
                case EXIT -> System.exit(0);
            }
        }
    } // End of main()


    private static int menu() {
        System.out.println("""
                Selecione uma opção:
                    [ 1 ] - Cadastrar
                    [ 2 ] - Editar
                    [ 3 ] - Excluir
                    [ 4 ] - Encontrar por id
                    [ 5 ] - Listar Usuários
                    [ 6 ] - Encerrar programa
                Opção:""");
        return sc.nextInt();
    } // End of menu()


    private static UserModel requestToCreateUser() {
        sc.nextLine();
        System.out.print("Digite seu nome: ");
        var name = sc.nextLine();
        System.out.print("Digite seu email: ");
        var email = sc.next().trim();
        System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
        var birthDate = sc.next();

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var dateOfBirth = LocalDate.parse(birthDate, formatter);

        return validateUser(0, name, email, dateOfBirth);
    } // End of requestToCreateUser()


    private static UserModel requestToUpdateUser() {
        System.out.print("Digite seu identificador (id): ");
        var id = sc.nextLong();
        sc.nextLine();
        System.out.print("Digite seu nome: ");
        var name = sc.nextLine();
        System.out.print("Digite seu email: ");
        var email = sc.next().trim();
        System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
        var birthDate = sc.next().trim();

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var dateOfBirth = LocalDate.parse(birthDate, formatter);

        return validateUser(id, name, email, dateOfBirth);
    } // End of requestToUpdateUser()


    private static long requestUserId() {
        sc.nextLine();
        System.out.print("Digite seu identificador (id): ");
        return sc.nextLong();
    } // End of requestUserId()


    private static UserModel validateUser(long id, String name, String email, LocalDate dateOfBirth) {
        var user = new UserModel(id, name, email, dateOfBirth);
        try {
            verifyModel(user);
            return user;
        } catch (ValidatorException ex) {
            throw new CustomException("O seu usuário contém erros: " + ex.getMessage());
        }
    }


} // End of class Main
