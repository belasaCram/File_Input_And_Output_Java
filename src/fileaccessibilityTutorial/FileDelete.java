/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileaccessibilityTutorial;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Marc Nelson Belasa
 */
public class FileDelete {
    
    public static void main(String[] args){
    
        Path filePath = Paths.get("C:\\Users\\Marc Nelson Belasa\\Desktop\\Sample\\Section2\\file3.txt");
        
        try
        {
            
            Files.delete(filePath);
            System.out.println("The file or directory is deleted");
            
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file or directory");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty");
        }
        catch(SecurityException e)
        {
            System.out.println("No permission to delete");
        }
        catch(IOException e)
        {
            System.out.println("IO exception");
        }
        
    }
    
}
