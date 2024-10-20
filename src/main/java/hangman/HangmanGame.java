package hangman;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;

public class HangmanGame {

    private static final String[] WORDS = {"elephant", "giraffe", "dolphin", "kangaroo", "panda"};
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getRandomWord();
        char[] displayWord = new char[wordToGuess.length()];
        HashSet<Character> guessedLetters = new HashSet<>();
        int remainingAttempts = MAX_ATTEMPTS;

        for (int i = 0; i < wordToGuess.length(); i++) {
            displayWord[i] = '_';
        }

        while (remainingAttempts > 0 && !isWordGuessed(displayWord)) {
            System.out.println("Current word: " + new String(displayWord));
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.println("Remaining attempts: " + remainingAttempts);
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.next().toLowerCase().charAt(0);

            if (guessedLetters.contains(guessedLetter)) {
                System.out.println("You've already guessed that letter!");
                continue;
            }

            guessedLetters.add(guessedLetter);

            if (updateDisplayWord(wordToGuess, displayWord, guessedLetter)) {
                System.out.println("Good guess!");
            } else {
                remainingAttempts--;
                System.out.println("Wrong guess! Try again.");
            }
        }

        if (isWordGuessed(displayWord)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Out of attempts! The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static String getRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    private static boolean updateDisplayWord(String word, char[] displayWord, char guessedLetter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guessedLetter) {
                displayWord[i] = guessedLetter;
                found = true;
            }
        }
        return found;
    }

    private static boolean isWordGuessed(char[] displayWord) {
        for (char c : displayWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
