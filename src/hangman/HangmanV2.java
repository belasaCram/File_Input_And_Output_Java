package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.*;

public class HangmanV2 {
    
     public static void main(String[] args) {
        Path path = Paths.get("Words.txt");
        String[] temparr = new String[100]; // Assuming max 100 words
        String[] newarr;
        Scanner jv = new Scanner(System.in);
        Random rnd = new Random();
        String hidenword;
        String showword;

        int counter = 0;

        try {
            InputStream input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String word;
            while ((word = reader.readLine()) != null) {
                temparr[counter] = word;
                ++counter;
            }
            newarr = new String[counter];
            System.arraycopy(temparr, 0, newarr, 0, counter);

            hidenword = newarr[rnd.nextInt(counter)];
            showword = hidenword.replaceAll("[a-zA-Z]", "?");

            boolean isTrue = true;
            boolean found;
            int attempts = 6; // Number of attempts allowed

            while (attempts > 0) {
                System.out.println("\n\n" + showword.toUpperCase() + "\n\n");
                System.out.println("Attempts left: " + attempts);

                System.out.println("Enter your guess letter or the word: ");
                String guess = jv.nextLine();

                if (guess.length() > 1) {
                    if (guess.equalsIgnoreCase(hidenword)) {
                        System.out.println("Good job! You guessed it! ");
                        System.exit(0);
                    } else {
                        System.out.println("Incorrect guess! ");
                        attempts--;
                    }
                } else {
                    found = false;
                    for (int x = 0; x < hidenword.length(); x++) {
                        if (guess.equalsIgnoreCase(String.valueOf(hidenword.charAt(x)))) {
                            showword = showword.substring(0, x) + guess + showword.substring(x + 1);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println(guess.toUpperCase() + " letter is not in the word! ");
                        attempts--;
                    } else {
                        System.out.println(guess.toUpperCase() + " letter is correct! ");
                    }
                }

                if (showword.equals(hidenword)) {
                    System.out.println("Congratulations! You guessed the word: " + hidenword);
                    System.exit(0);
                }
            }

            System.out.println("Sorry, you ran out of attempts! The word was: " + hidenword);

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
    }
}
