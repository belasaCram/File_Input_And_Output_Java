/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class HangmanChatGpt {
    private static final String[] WORDS = new String[20];
    private static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        int remainingTries = MAX_TRIES;

        // Initialize guessedWord with underscores
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");
        System.out.println("You have " + MAX_TRIES + " attempts.");
        System.out.println("The word has " + wordToGuess.length() + " letters.");
        System.out.println(displayWord(guessedWord));

        while (remainingTries > 0) {
            System.out.println("Guess a letter:");
            char guess = scanner.next().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                remainingTries--;
                System.out.println("Incorrect guess. You have " + remainingTries + " attempts left.");
            }

            System.out.println(displayWord(guessedWord));

            if (wordToGuess.equals(String.valueOf(guessedWord))) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                break;
            }
        }

        if (remainingTries == 0) {
            System.out.println("Sorry, you've run out of attempts. The word was: " + wordToGuess);
        }
    }

    private static String getRandomWord() {
        
       try
       {
            Path filePath = Paths.get("words.txt");
            BufferedReader reader = new BufferedReader(Files.newBufferedReader(filePath.toAbsolutePath()));
        
            int increment = 0;
            while(true)
            {
                String line = reader.readLine();
                if(line == null)
                    break;
                increment++;
                WORDS[increment] = line;
            }
        
       }catch(IOException e)
       {
           System.out.println("Exception");
       }

        
        int randomIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomIndex];
    }

    private static String displayWord(char[] guessedWord) {
        StringBuilder display = new StringBuilder();
        for (char c : guessedWord) {
            if (c == '_') {
                display.append('_');
            } else {
                display.append(c);
            }
            display.append(' ');
        }
        return display.toString();
    }
}
