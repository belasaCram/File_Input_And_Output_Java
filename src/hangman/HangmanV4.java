/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Hangman 
{
    private String secretWord;
    private List<Character> guessedLetters;
    private int attemptsLeft;

    public Hangman(String word) {
        secretWord = word.toLowerCase();
        guessedLetters = new ArrayList<>();
        attemptsLeft = 7;
    }
    
    
    public void guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (guessedLetters.contains(letter)) {
            System.out.println("You already guessed that letter!");
            return;
        }

        guessedLetters.add(letter);

        if (secretWord.indexOf(letter) == -1) {
            attemptsLeft--;
        }
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || isWordGuessed();
    }

    public boolean isWordGuessed() {
        for (char c : secretWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public void displayWordProgress() {
        for (char c : secretWord.toCharArray()) {
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
        return secretWord;
    }
}

public class HangmanV4 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "words.txt";
        List<String> words = readWordsFromFile(fileName);

        if (words.isEmpty()) {
            System.out.println("No words found in the file.");
            return;
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        
        Hangman hangman = new Hangman(word);

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the letters to uncover the secret word.");
        System.out.println("You have 7 attempts.");

        while (!hangman.isGameOver()) {
            System.out.println("\nAttempts left: " + hangman.getAttemptsLeft());
            hangman.displayWordProgress();

            System.out.print("Enter a letter: ");
            char letter = scanner.nextLine().charAt(0);
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
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
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
