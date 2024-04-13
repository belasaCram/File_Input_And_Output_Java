/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.io.*;
import java.util.*;

class GuessingGame 
{
    private String guessedWord;
    private List<Character> guessedLetters;
    private int attemptsLeft;

    public GuessingGame(String word) {
        guessedWord = word.toLowerCase();
        guessedLetters = new ArrayList<>();
        attemptsLeft = 10;
    }
    
    
    public void guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (guessedLetters.contains(letter)) {
            System.out.println("You already guessed that letter!");
            return;
        }

        guessedLetters.add(letter);

        if (guessedWord.indexOf(letter) == -1) {
            attemptsLeft--;
        }
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || isWordGuessed();
    }

    public boolean isWordGuessed() {
        for (char c : guessedWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public void displayWordProgress() {
        for (char c : guessedWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                System.out.print(c);
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getSecretWord() {
        return guessedWord;
    }
}


public class HangmanV3 {
    
      public static void main(String[] args) {
        Scanner ebok = new Scanner(System.in);
        String fileName = "words.txt";
        List<String> words = readWordsFromFile(fileName);

        if (words.isEmpty()) {
            System.out.println("There are no words found in the file!");
            return;
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        
        GuessingGame hangman = new GuessingGame(word);

        System.out.println("Welcome to Guessing Game1");
        System.out.println("Try to guess the word by using letters only. ");
        System.out.println("You only have 10 attempts.");

        while (!hangman.isGameOver()) {
            System.out.println("\nAttempts left: " + hangman.getAttemptsLeft());
            hangman.displayWordProgress();

            System.out.print("Enter a letter: ");
            char letter = ebok.nextLine().charAt(0);
            hangman.guessLetter(letter);

            if (hangman.isWordGuessed()) {
                System.out.println("Congratulations! You guessed the word: " + hangman.getSecretWord());
            } else if (hangman.getAttemptsLeft() <= 0) {
                System.out.println("Game over! The word was: " + hangman.getSecretWord());
            }
        }
    }

    public static List<String> readWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner ebok = new Scanner(file);
            while (ebok.hasNextLine()) {
                String word = ebok.nextLine().trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
            ebok.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be found");
        }
        return words;
    }

    public static void saveWordsToFile(List<String> words, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (String word : words) {
                writer.write(word + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }
    
}
