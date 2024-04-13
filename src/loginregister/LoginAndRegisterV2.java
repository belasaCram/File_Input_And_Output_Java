/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginregister;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Scanner;

/**
 *
 * @author Marc Nelson Belasa
 */
public class LoginAndRegisterV2 {
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Register\n2. Login");
        int choice = scan.nextInt();
        scan.nextLine();
        
        if (choice == 1) {
            System.out.print("Enter First Name: ");
            String firstName = scan.nextLine();
            System.out.print("Enter Middle Name: ");
            String middleName = scan.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scan.nextLine();
            
            String fullName = firstName + " " + middleName + " " + lastName;
            
            System.out.print("Enter age: ");
            int age = scan.nextInt();
            scan.nextLine();
            
            System.out.print("Enter email: ");
            String email = scan.nextLine();
            
            registerUser(fullName, age, email);
        } else if (choice == 2) {
            loginUser();
        }
        scan.close();
    }
    
    public static void registerUser(String fullname, int age, String email)
    {
        Scanner scan = new Scanner(System.in);
        try
        {
            Path filePath = Paths.get("records.txt");
            
            System.out.print("\nEnter username: ");
            String username = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();
            
            BufferedOutputStream output = new BufferedOutputStream(Files.newOutputStream(filePath, CREATE, APPEND)); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            String format = username + "," + password + "," + fullname +"," + String.valueOf(age) + "," + email ;
           
            writer.write(format);
            writer.newLine();
            writer.close();
            
            System.out.println("User registered successfully.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        scan.close();
        
    }
    
    public static void loginUser()
    {
        try
        {
            Scanner scan = new Scanner(System.in);
            Path filePath = Paths.get("records.txt");
            BufferedReader reader = new BufferedReader(Files.newBufferedReader(filePath));
            boolean foundFlag = false;

            while(true)
            {
                System.out.print("\nEnter username: ");
                String username = scan.nextLine();
                System.out.print("Enter password: ");
                String password = scan.nextLine();

                while(true)
                {
                    String line = reader.readLine();
                    if(line == null)
                        break;

                    String[] parts = line.split(",");

                    if(parts[0].equals(username) && parts[1].equals(password))
                    {
                        System.out.println("\nHello " + parts[2]);
                        System.out.println("Age : " + parts[3]);
                        System.out.println("Email : " + parts[4]);
                        foundFlag = true;
                        reader.close();
                        break;
                    }
                }

                if (foundFlag) {
                    System.out.println("Login successful.");
                    break;
                } else {
                    System.out.println("Invalid username or password.");
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
