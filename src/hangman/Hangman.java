/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class Hangman
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] words = getGuessingWords();
        String wordToGuess = randomWords(words);
        char[] guessedWord = new char[wordToGuess.length()];
        int remainingTries = 5;
 
        // Initialize guessedWord with underscores
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '?';
        }
        
        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");
        System.out.println("You have " + remainingTries + " attempts.");
        System.out.println(wordToGuess);
        System.out.println("The word has " + wordToGuess.length() + " letters.");
        System.out.println(displayWord(guessedWord));
        
        while (remainingTries > 0) {
            System.out.println("Guess a letter:");
            char guess = scan.next().charAt(0);

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
    
    public static String[] getGuessingWords()
    {
        String[] words = new String[20];
        Path fileName = Paths.get("words.txt");
        Path filePath = fileName.toAbsolutePath();
        
        try
        {
            BufferedReader reader = new BufferedReader(Files.newBufferedReader(filePath));
            for(int i = 0; i < words.length; i++)
            {
                words[i] = reader.readLine();
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return words;
    }
    
    public static String randomWords(String[] words)
    {
        int index = (int)(Math.random() * words.length);
        return words[index];
    }
    
    private static String displayWord(char[] guessedWord) 
    {
        String display = "";
        for (char c : guessedWord) 
        {
            if(c == '?')
            {
                display += '?';
            }
            else
            {
                display += c;
            }
            display += ' ';
        }
        
        return display;
    }
}
