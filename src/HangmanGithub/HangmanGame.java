/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HangmanGithub;

import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class HangmanGame 
{
    
    public static void main(String[] args) 
    {
        
        GameEngine gameEngine = new GameEngine();
        Messages message = new Messages();
        
        int numberOfGuesses = 5;
        int countGuesses = 0;
        
        String word = gameEngine.WordToGuess();
        String hiddenWord = gameEngine.HideWord(word);
        
        message.StartGame();
        message.CanYouGuessTheWord();
        
        System.out.println(gameEngine.AddSpaces(hiddenWord));
        System.out.println();

        while (true) 
        {
            Scanner input = new Scanner(System.in);
            char letter = input.next().charAt(0);

            boolean foundLetter = gameEngine.
                    CheckIfTheLetterIsCorrect(letter, word);

            if (foundLetter) 
            {
                hiddenWord = gameEngine.
                        PlaceLetterInTheHiddenWord(letter,word, hiddenWord);
                System.out.println(gameEngine.AddSpaces(hiddenWord));
            }
            else 
            {
                countGuesses++;
            }

            if (hiddenWord.equals(word)) 
            {
                message.GameOverMessage("Cool! You are a genius!", word, true);
                gameEngine.EndGame();
            }
            
            if (countGuesses == numberOfGuesses) 
            {
                message.GameOverMessage("You loose! The word you couldn't guess was", word, false);
                gameEngine.EndGame();
            }
        }
    }
}
