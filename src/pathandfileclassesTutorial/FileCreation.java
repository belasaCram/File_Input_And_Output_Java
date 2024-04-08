/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pathandfileclassesTutorial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class FileCreation {
    
    public static void main(String[] args){
    
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your name:");
        String name = scan.nextLine();
        System.out.print("Enter your section: ");
        String section = scan.nextLine();
        
        try(FileWriter fw = new FileWriter("file.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw))
        {
            pw.println(name);
            pw.println(section);
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
