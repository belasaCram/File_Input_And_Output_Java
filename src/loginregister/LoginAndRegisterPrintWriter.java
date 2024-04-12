/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginregister;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
/**
 *
 * @author Marc Nelson Belasa
 */
public class LoginAndRegisterPrintWriter 
{
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to Fishbook");
        while(true)
        {
            System.out.println("L: Login\nR: Register");
            String choice = scan.nextLine().toLowerCase();
            
            if(choice.equals("r"))
            {
                System.out.println("Enter username: ");
                String username = scan.nextLine();
                System.out.println("Enter password: ");
                String password = scan.nextLine();

                String userData = username + "," + password;
                
                try(
                    FileWriter fw = new FileWriter("records.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw)
                    )
                {
                    pw.println(userData);
                }
                catch(IOException e)
                {
                    System.out.println("IO Exception");
                }
                
            }
            else if(choice.equals("l"))
            {
                while(true)
                {
                    try
                    {
                        Path filePath = Paths.get("C:\\Users\\Marc Nelson Belasa\\Documents\\NetBeansProjects\\FileInputAndOutputTutorial\\records.txt");
                        BufferedReader reader = new BufferedReader(Files.newBufferedReader(filePath));

                        System.out.println("Enter username: ");
                        String username = scan.nextLine();
                        System.out.println("Enter password: ");
                        String password = scan.nextLine();

                        String userData = username + "," + password;

                        String fromNotepad;
                        while((fromNotepad = reader.readLine()) != null)
                        {
                            if(userData.equals(fromNotepad))
                            {
                                System.out.println("Successfully Login");
                                return;
                            }
                        }

                        System.out.println("Invalid username or password.");
                    }
                    catch(IOException e)
                    {
                        System.out.println("IO Exception");
                    }
                }
            }
            else
            {
                System.out.println("Invalid Input! Only (L/R) are accepted.");
            }
        }
    }
}
