/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Marc Nelson Belasa
 */
public class HangmanBard {
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        // Pick a random word
        String word = pickRandomWord();

        // Convert the word to an array list of characters
        ArrayList<Character> wordChars = new ArrayList<>();
        for (char c : word.toCharArray()) 
        {
          wordChars.add(c);
        }

        // Create an array list to store the guessed letters
        ArrayList<Character> guessedLetters = new ArrayList<>();

        // Create a variable to store the number of guesses remaining
        int numGuesses = 10;

        // Game loop
        while (true) 
        {
          // Display the current state of the word
          System.out.println(displayWord(word, guessedLetters, true, 2, 0));

          // Check if the word has been guessed
          boolean isWordGuessed = true;
          for (char c : wordChars) 
          {
            if (!guessedLetters.contains(c)) 
            {
              isWordGuessed = false;
              break;
            }
          }

          if (isWordGuessed) 
          {
            System.out.println("Congratulations! You guessed the word!");
            break;
          }

          // Check if the number of guesses is zero
          if (numGuesses == 0) 
          {
            System.out.println("Sorry, you ran out of guesses. The word was: " + word);
            break;
          }

          // Get the user's guess
          System.out.print("Guess a letter: ");
          Scanner scanner = new Scanner(System.in);
          char guess = scanner.next().charAt(0);

          // Check if the guess is valid
          if (!Character.isLetter(guess)) 
          {
            System.out.println("Invalid guess. Please enter a letter.");
            continue;
          }

          // Check if the user has already guessed the letter
          if (guessedLetters.contains(guess)) 
          {
            System.out.println("You already guessed that letter. Please try again.");
            continue;
          }

          // Add the guess to the guessed letters list
          guessedLetters.add(guess);

          // Check if the guess is correct
          if (word.indexOf(guess) != -1) 
          {
            System.out.println("Correct!");
          } else 
          {
            System.out.println("Incorrect. You have " + numGuesses + " guesses remaining.");
            numGuesses--; // Decrease the number of guesses remaining
          }
        }
    }
    
    public static String pickRandomWord() 
    {
        try
        {
            Path fileName = Paths.get("words.txt");
            // Create an array to store all the words in the file
            BufferedReader reader = new 
                BufferedReader(Files.newBufferedReader(fileName.toAbsolutePath()));
            ArrayList<String> words = new ArrayList<>();

            while (true) 
            {
                String line = reader.readLine();
                if(line == null)
                    break;
                
                words.add(line);
            }

            // Get a random number between 0 and the number of words in the array
            Random random = new Random();
            int randomIndex = random.nextInt(words.size());
            
            return words.get(randomIndex);
        }
        catch(IOException e)
        {
            System.out.println("IO Exception");
            return null;
        }
    }
    
//    public static String displayWord(String word, ArrayList<Character> guessedLetters) {
//        String displayedWord = "";
//        for (char letter : word.toCharArray()) {
//          if (guessedLetters.contains(letter)) {
//            displayedWord += letter;
//          } else {
//            displayedWord += "?";
//          }
//        }
//        return displayedWord;
//    }
//    
//    public static String displayWord(String word, int numCharsToHide, int startPos) {
//        StringBuilder displayedWord = new StringBuilder();
//        int charsHidden = 0;
//
//        for (int i = 0; i < word.length(); i++) {
//          if (charsHidden < numCharsToHide && i >= startPos) {
//            displayedWord.append('?');
//            charsHidden++;
//          } else {
//            displayedWord.append(word.charAt(i));
//          }
//        }
//        return displayedWord.toString();
//    }
    
    public static String displayWord(
            String word,
            ArrayList<Character> guessedLetters,
            boolean hideSomeChars,
            int numCharsToHide,
            int startPos) 
    {
        String displayedWord = "";
        int charsHidden = 0;

        for (int i = 0; i < word.length(); i++) 
        {
            if (hideSomeChars && charsHidden < numCharsToHide && i >= startPos) 
            {
                displayedWord += '?';
                charsHidden++;
            } 
            else if (guessedLetters.contains(word.charAt(i))) 
            {
                displayedWord += word.charAt(i);
            } 
            else 
            {
                displayedWord += '?';
            }
        }
        return displayedWord;
    }
}
