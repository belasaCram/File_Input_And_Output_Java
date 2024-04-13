/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginregister;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class LoginAndRegisterV3 {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        
          // Read words from the file
        try {
            
            File file = new File("C:\\Users\\georg\\Documents\\NetBeansProjects\\LabExer6A\\words.txt");
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine()) 
            {
                words.add(fileScanner.nextLine());
            }
            
            fileScanner.close();
            
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found!");
            return;
        }
        
        // Select a random word
        String word = words.get(new Random().nextInt(words.size()));
        int wordLength = word.length();
        char[] guessedWord = new char[wordLength];
        Arrays.fill(guessedWord, '?');
        
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Guess the word: " + String.valueOf(guessedWord));
        
        // loop
        while (true) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            boolean correctGuess = false;
            
            // Check if the guessed letter is in the word
            for (int i = 0; i < wordLength; i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }
            
            // Display the current state of the guessed word
            System.out.println("Current state of the word: " + String.valueOf(guessedWord));
            
            // Check if the word has been guessed
            if (Arrays.equals(guessedWord, word.toCharArray())) {
                System.out.println("Congratulations! You guessed the word: " + word);
                break;
            }
            
            // Inform the user if the guessed letter is not in the word
            if (!correctGuess) {
                System.out.println("Sorry, the guessed letter is not in the word.");
            }
        }
        
        scanner.close();
    }
}
