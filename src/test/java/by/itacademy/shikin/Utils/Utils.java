package by.itacademy.shikin.Utils;

import com.github.javafaker.Faker;

public class Utils {
    static Faker faker = new Faker();

    public static String generateEmail() {
        String email = faker.internet().emailAddress();
        return email;
    }

    public static String generatePassword() {
        String password = faker.internet().password();
        return password;
    }
}