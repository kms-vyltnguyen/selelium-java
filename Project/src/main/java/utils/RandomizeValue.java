package utils;

import java.util.Arrays;
import java.util.Random;

public class RandomizeValue {
    public static String randomValue(String value) {
        int random;
        random = Math.abs(new Random().nextInt() % 100000000 + 1);
        return value + "_" + String.valueOf(random);
    }

    public static String randomMail(String mail) {
        int random = Math.abs(new Random().nextInt() % 100000000 + 1); //random range 1-10000
        String[] mailSplit = mail.split("@");
        mail = mailSplit[0] + String.valueOf(random) + "@" + mailSplit[1];
        return mail;
    }

    public static String randomPhoneNumber(String value) {
        int random;
        random = Math.abs(new Random().nextInt() % 100000000 + 1);
        return value + String.valueOf(random);
    }

    public static String randomUEN() {
        int random;
        random = Math.abs(new Random().nextInt() % 100000000 + 1);
        return String.valueOf(random) + "a";
    }
}
