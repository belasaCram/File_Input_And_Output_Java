/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bufferedoutputTutorial;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class BufferedWriterSample 
{
    
    public static void main(String[] args)
    {
        // We create a Scanner object to read input from the console.
        Scanner input = new Scanner(System.in);
        
        // We create a Path object representing the file where we want to write the student data.
        Path file = Paths.get("");
        
        // We declare variables to store student information.
        long id;
        String name;
        double grade;
        final long QUIT = 0;
        
        // We're going to try to do some actions. If anything goes wrong, we'll catch the problem and deal with it.
        try {
            
            // We create an output stream to write data to the file.
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
            
            // We create a BufferedWriter to efficiently write characters to the output stream.
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            // We prompt the user to enter a student ID number.
            System.out.print("Enter student ID number: ");
            id = input.nextLong();
            
            // We iterate until the user enters the quit command.
            while(id != QUIT) {
                
                // We prompt the user to enter the student's name.
                System.out.print("Enter name for student no. " + id + ": ");
                input.nextLine(); // Consume the newline character left by nextLong()
                name = input.nextLine();
                
                // We prompt the user to enter the student's grade.
                System.out.println("Enter the subject grade: ");
                grade = input.nextDouble();
                
                // We format the grade to two decimal places.
                DecimalFormat df = new DecimalFormat("0.00");
                
                // We construct a string representing the student's data.
                String studentData = id + "," + name + "," + df.format(grade);
                
                // We write the student's data to the file.
                writer.write(studentData, 0, studentData.length());
                
                // We move to the next line in the file.
                writer.newLine();
                
                // We prompt the user to enter the next student ID number or to quit.
                System.out.println("Enter next ID number or " + QUIT + " to quit: ");
                id = input.nextLong();
            }
        
            // We close the writer to release resources.
            writer.close();
            
        } catch(Exception e) { // If something goes wrong during these actions, we'll handle the problem here.
            
            // We print out an error message to let the user know something went wrong.
            System.out.println("Message: " + e);
        }
    }
}
