/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pathandfileclassesTutorial;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 *
 * @author Marc Nelson Belasa
 */
public class PathSample {
    
    public static void main(String[] args){
    
        Scanner scan = new Scanner(System.in);
        
        Path filePath = Paths.get("C:\\Users\\Marc Nelson Belasa\\Documents\\NetBeansProjects\\FileInputAndOutputTutorial\\file.txt");        
        
        int count = filePath.getNameCount(); // .getNameCount() count it based on the directory
        
        System.out.println("Path is " + filePath.toString()); // 
        
        System.out.println("File name is " + filePath.getFileName()); //
        
        System.out.println("There are " + count + " elements in the file path");
        
        System.out.println("Count Value " + count);
        
        for(int i = 0; i < count; i++){
            System.out.println("Element " + i + " is " + filePath.getName(i));
            System.out.println("index value " + i);
            scan.nextLine();
        }        
    
    }
}
