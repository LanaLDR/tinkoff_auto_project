package ru.tinkoff.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private Faker fakerRu = new Faker(new Locale("ru"));

    public String getShortWrongPhone() {
        return "+7"+getRandomInt(1, 9999999);
    }

    public String getLongWrongPhone() {
        return "+7"+fakerRu.numerify("#############");
    }

    public String getCorrectPhone() {
        return fakerRu.phoneNumber().phoneNumber();
    }

    public String getWrongSmsCode() {
        return fakerRu.numerify("####");
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
