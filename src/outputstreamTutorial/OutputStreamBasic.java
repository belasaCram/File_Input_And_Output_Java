/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outputstreamTutorial;

import java.io.OutputStream;

/**
 *
 * @author Marc Nelson Belasa
 */
public class OutputStreamBasic 
{   
    
    public static void main(String[] args)
    {
        // We create a word "RANIKA" that we want to print.
        String word = "RANIKA";
        
        // We convert this word into a format that the computer can understand, called bytes.
        byte[] data = word.getBytes();
        
        // We set up a way to send our data somewhere, but for now, we'll send it to the console.
        // We call this 'output'.
        OutputStream output = null;
        
        // We're going to try to do some actions. If anything goes wrong, we'll catch the problem and deal with it.
        try {
            
            // Here, we decide that the 'output' will be the console.
            output = System.out;
            
            // We write our data (our word in bytes) to the output (the console).
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
