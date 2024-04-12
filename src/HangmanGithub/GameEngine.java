/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HangmanGithub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class GameEngine 
{
    public String WordToGuess() 
    {
        ArrayList<String> words = ReadWordsFromFile();
        Random rand = new Random();

        int n = rand.nextInt(words.size());
        return words.get(n);
    }

    public ArrayList<String> ReadWordsFromFile() 
    {
        BufferedReader reader;
        ArrayList<String> wordsArr = new ArrayList<String>();
        try 
        {
            reader = new BufferedReader(new FileReader("words.txt"));
            String line = null;

            while ((line = reader.readLine()) != null) 
            {
                wordsArr.add(line);
            }

            reader.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error");
        }
        return wordsArr;
    }

    public String HideWord(String word) 
    {
        return word.replaceAll("[a-zA-Z]", "_");
    }

    public String AddSpaces(String word) 
    {
        char[] wordArr = word.toCharArray();
        String wordWithSpace = "";

        for (int i = 0; i < wordArr.length; i++) 
        {
            wordWithSpace += wordArr[i] + " ";
        }
        return wordWithSpace;
    }

    public boolean CheckIfTheLetterIsCorrect(char letter, String word) 
    {
        char[] wordArr = word.toCharArray();

        for (int i = 0; i < wordArr.length; i++) 
        {
            if (letter == (wordArr[i]))
            {
                return true;
            }
        }
        return false;
    }

    public String PlaceLetterInTheHiddenWord(
        char letter,
        String word,
        String currentHiddenWord) 
    {
        char[] wordArr = word.toCharArray();
        char[] currentWordArr = currentHiddenWord.toCharArray();

        for (int i = 0; i < wordArr.length; i++) 
        {
            if (letter == (wordArr[i])) 
            {
                currentWordArr[i] = letter;
            }
        }

        String currentWordWithFoundLetter = "";

        for (int i = 0; i < currentWordArr.length; i++) 
        {
            currentWordWithFoundLetter += currentWordArr[i];
        }

        return currentWordWithFoundLetter;
    }

    public void EndGame() 
    {
            System.out.println("Do you want to try and guess another word? Y/N");
            Scanner sc = new Scanner(System.in);
            String newGame = sc.nextLine().toLowerCase();
            
            if (newGame.equals("y")) 
            {
                    new HangmanGame().main(new String[0]);
            } 
            else 
            {
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
    }
}
