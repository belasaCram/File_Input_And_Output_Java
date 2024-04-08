/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileattributeTutorial;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
/**
 *
 * @author Marc Nelson Belasa
 */
public class FileAttributeCompareCreationTime 
{
    
    public static void main(String[] args)
    {
        
        // We create two Path objects representing the paths to the files we want to compare.
        // Here, both paths are empty, so we'll need to specify the actual paths of the files we want to compare.
        Path filePath1 = Paths.get("");
        Path filePath2 = Paths.get("");
        
        // We're going to try to do some actions. If anything goes wrong, we'll catch the problem and deal with it.
        try {
            
            // We read the basic file attributes of the first file.
            BasicFileAttributes fileAtt1 = Files.readAttributes(filePath1, BasicFileAttributes.class);
            
            // We read the basic file attributes of the second file.
            BasicFileAttributes fileAtt2 = Files.readAttributes(filePath2, BasicFileAttributes.class);

            // We get the creation time of the first file.
            FileTime time1 = fileAtt1.creationTime();
            
            // We get the creation time of the second file.
            FileTime time2 = fileAtt2.creationTime();

            // We print out the creation times of both files.
            System.out.println("fileAtt1's creation time is " + time1);
            System.out.println("fileAtt2's creation time is " + time2);

            // We compare the creation times of the files.
            // If the creation time of file1 is before the creation time of file2, we print a message indicating so.
            if(time1.compareTo(time2) < 0) {
                System.out.println("file2 was created after file1");
            }
            // If the creation time of file2 is before the creation time of file1, we print a message indicating so.
            else if(time2.compareTo(time1) > 0) {
                System.out.println("file1 was created after file2");
            }
            // If both files were created at the same time, we print a message indicating so.
            else {
                System.out.println("file1 and file2 were created at the same time.");
            }
        
        } catch(IOException e) { // If something goes wrong during these actions, we'll handle the problem here.
            
            // We print out an error message to let the user know something went wrong.
            System.out.println("IO Exception");
        }
    }
}
