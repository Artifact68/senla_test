package passwordgenerator;

import java.util.Scanner;
import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "@#$%&*!?";
    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + DIGITS + SPECIALS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.print("Enter password length (8-12): ");
        int length = scanner.nextInt();

        if (length < 8 || length > 12) {
            System.out.println("Invalid password length! Please choose between 8 and 12.");
        } else {
            String password = generatePassword(length, random);
            System.out.println("Generated Password: " + password);
        }

        scanner.close();
    }

    private static String generatePassword(int length, SecureRandom random) {
        StringBuilder password = new StringBuilder(length);

        password.append(getRandomCharacter(UPPERCASE, random));
        password.append(getRandomCharacter(LOWERCASE, random));
        password.append(getRandomCharacter(DIGITS, random));
        password.append(getRandomCharacter(SPECIALS, random));

        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(ALL_CHARS, random));
        }

        return password.toString();
    }

    private static char getRandomCharacter(String characterSet, SecureRandom random) {
        int index = random.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }
}
