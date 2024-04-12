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
    
         Scanner scan = new Scanner(System.in); // Creating a Scanner object to read user input

        // Creating a Path object representing the file path
        Path filePath = Paths.get("C:\\Users\\Marc Nelson Belasa\\Documents\\NetBeansProjects\\FileInputAndOutputTutorial\\file.txt");

        // Getting the count of elements (directories and file name) in the file path
        int count = filePath.getNameCount();

        // Printing the file path and file name
        System.out.println("Path is " + filePath.toString());
        
        System.out.println("File name is " + filePath.getFileName());

        // Printing the count of elements in the file path
        System.out.println("There are " + count + " elements in the file path");
        
        System.out.println("Count Value " + count + "\n");

        // Iterating over each element in the file path and printing its details
        for (int i = 0; i < count; i++) 
        {
            // Printing the index and the name of each element in the file path
            System.out.println("Element " + i + " is " + filePath.getName(i));
            System.out.println("index value " + i);
            scan.nextLine(); // Waiting for the user to press Enter before printing the next element
        }

        scan.close(); // Closing the Scanner object to release resources 
    
    }
}
