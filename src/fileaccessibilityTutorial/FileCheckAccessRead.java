/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileaccessibilityTutorial;

import java.io.IOException;
import static java.nio.file.AccessMode.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Marc Nelson Belasa
 */
public class FileCheckAccessRead {
    
    public static void main(String[] args){
    
        
        String fileName = "file.txt";
        Path filePath = Paths.get("C:\\Users\\Marc Nelson Belasa\\Documents\\NetBeansProjects\\FileInputAndOutputTutorial\\" + fileName);

        System.out.println("Path is " + filePath.toString());
        
        try{
            
//            filePath.getFileSystem().provider().checkAccess(filePath, WRITE, EXECUTE);
              filePath.getFileSystem().provider().checkAccess(filePath);
              
        }catch(IOException e){
            System.out.println("The file cannot be used");
        }
    }
}
