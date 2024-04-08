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
public class AbsolutePath {
    
    public static void main(String[] args){
    
        String fileName;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter filename: ");
        fileName = scan.nextLine();
        
        Path inputPath = Paths.get(fileName);
        Path fullPath = inputPath.toAbsolutePath();
        
        System.out.println("The full Path is " + fullPath.toString());
    
    }
}
