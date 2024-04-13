package loginregister;

import java.io.*;
import java.util.Scanner;

public class LoginAndRegister {
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Register\n2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (choice == 1) {
            registerUser();
        } else if (choice == 2) {

            while(true){
                
                System.out.print("\nEnter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
            
                if (loginUser(username, password)) {
                    System.out.println("Login successful.");
                    break;
                } else {
                    System.out.println("Invalid username or password.");
                }
            }
        }
        scanner.close();
    }
    
    public static void registerUser()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Id number: ");
            int idNumber = scanner.nextInt();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            name = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            
            System.out.print("\nEnter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            
            PrintWriter writer = new PrintWriter(new FileWriter("records.txt", true));
            
            String format = username + "," + password + "," + idNumber + "," + name + "," + email;
            writer.println(format);
            writer.close();
            scanner.close();
            System.out.println("User registered successfully.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static boolean loginUser(String username, String password)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("records.txt"));

            while(true)
            {
                String line = reader.readLine();
                if(line == null)
                    return false;
                
                String[] parts = line.split(",");
                
                if(parts[0].equals(username) && parts[1].equals(password))
                {
                    System.out.println("\nHello " + parts[3]);
                    System.out.println("Id number : " + parts[2]);
                    System.out.println("Email : " + parts[4]);
                    reader.close();
                    return true;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    
}
