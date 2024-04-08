/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bufferedoutputTutorial;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author Marc Nelson Belasa
 */
public class BufferedWriter_WRITE_READ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //The format of the file path must be : "C:\\Users\\Marc Nelson Belasa\\Documents\\NetBeansProjects\\BufferedWriterTutorial\\"
        
        String fileName = "sample.txt"; //Name of the file
        Path filePath = Paths.get("C:\\Users\\Marc Nelson Belasa\\Documents\\NetBeansProjects\\BufferedWriterTutorial\\" + fileName); //File Path

        
        // Writing to file
        try {
            //Initialize 
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(filePath, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            // Writing a single character
            writer.write('A');

            // Writing a string
            writer.write("Hello, BufferedWriter!");

            // Writing a string with newline character
            writer.newLine();

            // Writing an array of characters
            char[] chars = {'J', 'a', 'v', 'a'};
            writer.write(chars);

            // Writing a portion of a character array
            writer.write(chars, 1, 3); // Writes "av"
            
            // Writing a string followed by a newline
            writer.write("New line");
            writer.newLine();

            // Flushing the writer
            writer.flush();
            
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Reading from file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // FileReader is wrapped inside BufferedReader for efficient reading
            // FileReader is used to read characters from the file indicated by fileName

            String line; // Variable to store each line read from the file
            System.out.println("Reading from file:"); // Printing a message indicating reading from file

            // Loop to read lines from the file until end of file (null is returned)
            while ((line = reader.readLine()) != null) {
                // Each line read is printed to the console
                System.out.println(line);
            }
        } catch (IOException e) {
            // Exception handling block to catch IOException
            // IOException may occur during file reading operations
            System.err.println("Error reading from file: " + e.getMessage());
            // Printing error message if IOException occurs
        }
    }
}
    
