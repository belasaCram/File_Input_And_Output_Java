/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginregister;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

/**
 *
 * @author Marc Nelson Belasa
 */
public class LoginAndRegisterPT 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("#########################");
        System.out.println("(1)Login\n(2)Register");
        int choice = scan.nextInt();
        
        switch (choice) {
            case 1 -> Login();
            case 2 -> Register();
            default -> System.out.println("Invalid Input");
        }
    }
    
    public static void Register()
    {
        Path fileName = Paths.get("records.txt");
        Path filePath = fileName.toAbsolutePath();
        Scanner scan = new Scanner(System.in);
        try
        {
            BufferedOutputStream output = new BufferedOutputStream(Files.newOutputStream(filePath, CREATE, APPEND)); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            System.out.println("#########################");
            System.out.println("Registration");
            System.out.println("#########################");
            System.out.print("Enter name: ");
            String name = scan.nextLine();
            System.out.print("Enter section: ");
            String section = scan.nextLine();
            System.out.print("Enter age: ");
            int age = scan.nextInt();
            System.out.println("#########################");
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            username = scan.nextLine();
            System.out.print("Enter password: ");
            String password = scan.nextLine();
            
            String userCredentials = name + "," + section + "," + age + "," + username + "," + password;
            String userData = username + "," + password;
            
            RegisterCredentials(userCredentials);
            
            writer.write(userData);
            writer.newLine();
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception");
        }
    }
    
    public static void RegisterCredentials(String userCredentials)
    {
        Path fileName = Paths.get("userdata.txt");
        Path filePath = fileName.toAbsolutePath();
        Scanner scan = new Scanner(System.in);
        try
        {
            BufferedOutputStream output = new BufferedOutputStream(Files.newOutputStream(filePath, CREATE, APPEND)); 
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
            writer.write(userCredentials);
            writer.newLine();
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception");
        }
    
    }
    
    public static void Login()
    {
        Path fileUserData = Paths.get("records.txt");
        Path fileCredentials = Paths.get("userdata.txt");
        Path filePathUserData = fileUserData.toAbsolutePath();
        Path filePathCredentials = fileCredentials.toAbsolutePath();

        Scanner scan = new Scanner(System.in);
        try
        {
            BufferedReader readerUserdata = new BufferedReader(Files.newBufferedReader(filePathUserData));
            BufferedReader readerCredentials = new BufferedReader(Files.newBufferedReader(filePathCredentials));

            
            System.out.println("#########################");
            System.out.println("Login");
            while(true)
            {
                System.out.println("#########################");
                System.out.print("Username: ");
                String username = scan.nextLine();
                System.out.print("Password: ");
                String password = scan.nextLine();
                System.out.println("#########################");

                String userData = username + "," + password;
                String lineUserData = "", lineCredentials = "";

                while (true){
                    lineUserData = readerUserdata.readLine();
                    lineCredentials = readerCredentials.readLine();
                    if(lineUserData == null)
                        break;

                    if(lineUserData.equals(userData))
                    {
                        System.out.println("Successfully logged in");
                        System.out.println("Hello! " + lineCredentials);
                        return;
                    }
                    else
                    {
                        System.out.println("Incorrect username or password");
                        break;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Exception");
        }
    }
}
