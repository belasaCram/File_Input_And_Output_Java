/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bufferedoutputTutorial;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

/**
 *
 * @author Marc Nelson Belasa
 */
public class BufferedOutputStreamSample 
{

    public static void main(String[] args)
    {
        // We create a Path object that represents the file we want to write to.
        // Here, we're creating a file object with an empty path, which doesn't point to any specific location.
        // We'll need to specify the path where we want to create the file.
        Path file = Paths.get("");
        
        // We create a word "Ranika" that we want to write into the file.
        String word = "Ranika";

        // We convert this word into a format that the computer can understand, called bytes.
        byte[] data = word.getBytes();
        
        // We set up a way to send our data somewhere. Here, we're setting up to send it to a file.
        OutputStream output = null;
        
        // We're going to try to do some actions. If anything goes wrong, we'll catch the problem and deal with it.
        try {
            
            // We create a new output stream to write data to the file.
            // We wrap this output stream with a BufferedOutputStream for better performance.
            // We use the Files class to create the output stream, specifying the file path and indicating we want to create the file if it doesn't exist.
            output = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
            
            // We write our data (our word in bytes) to the output stream (the file).
            output.write(data);
            
            // We make sure that all our data is sent out immediately.
            output.flush();
            
            // We're done sending our data, so we close the output connection.
            output.close();
            
        } catch(Exception e) { // If something goes wrong during these actions, we'll handle the problem here.
            
            // We print out an error message to let the user know something went wrong.
            System.out.println("Message: " + e);
            
        }
    }
}
