package com.dsd;

import java.util.Scanner;

public class Main {

    public static boolean validation (String login, String password, String passwordConfirm){
        boolean bol = true;
        String regex = "\\w{1,19}";

        try {
            if (!login.matches(regex))
                throw new WrongLoginException
                        ("Логин должен содержать менее 20 символов и содержать только буквы, цифры и \"_\".");
            if (!password.matches(regex))
                throw new WrongLoginException
                        ("Пароль должен содержать менее 20 символов и содержать только буквы, цифры и \"_\".");
            if (!password.equals(passwordConfirm))
                throw new WrongPasswordException
                        ("Поля пароль и подтверждение пароля не совпадают.");
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
            bol = false;
        }
        return bol;
    }

    public static void main(String[] args) {
        // String login = "1234567890123456789";
        // String password = "12345";
        // String passwordConfirm = "12355";

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = sc.nextLine();
        System.out.println("Введите пароль");
        String password = sc.nextLine();
        System.out.println("Повторите пароль");
        String passwordConfirm = sc.nextLine();

        if (validation(login,password,passwordConfirm)) System.out.println("Логин и пароль заданы");
        else System.out.println("Логин и пароль не заданы, повторите попытку.");

    }
}
