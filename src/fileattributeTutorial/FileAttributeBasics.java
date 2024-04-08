/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileattributeTutorial;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 *
 * @author Marc Nelson Belasa
 */
public class FileAttributeBasics 
{
    
    
    public static void main(String[] args)
    {
        // We create a Path object representing the path to the file we want to get attributes for.
        Path filePath = Paths.get("C:\\Users\\Marc Nelson Belasa\\Desktop\\Sample\\Section2\\file3.txt");
        
        // We're going to try to do some actions. If anything goes wrong, we'll catch the problem and deal with it.
        try {
            
            // We read the basic file attributes of the file.
            BasicFileAttributes fileAtt = Files.readAttributes(filePath, BasicFileAttributes.class);
            
            // We print out the size of the file.
            System.out.println("Size: " + fileAtt.size());
            
            // We print out the creation time of the file.
            System.out.println("Creation time: " + fileAtt.creationTime());
            
            // We print out the last modified time of the file.
            System.out.println("Last modified time: " + fileAtt.lastModifiedTime());
        
        } catch(IOException e) { // If something goes wrong during these actions, we'll handle the problem here.
            
            // We print out an error message to let the user know something went wrong.
            System.out.println("IO Exception");
        }
    }
}
