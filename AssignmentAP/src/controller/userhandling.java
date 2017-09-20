package controller;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.user;

public class userhandling {
    private static ObjectInputStream myfile;
    
    public static void openFile(){
        try // open file
        {
            myfile = new ObjectInputStream(Files.newInputStream(Paths.get("users.ser")));
        }    
        catch (IOException ioException)
        {
           System.err.println("Cannot open the file.");
           System.exit(1); 
        }
    }
    
    public static List readRecords(){
        List<user> userlist=new ArrayList();
        openFile();
        try
        {
            while (true) // loop until there is an EOFException
            {   
                userlist.add((user) myfile.readObject());
            }
        }
        catch (EOFException endOfFileException)
        {
            System.out.printf("End of records%n");
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.err.println("Object is invalid.");
        }
        catch (IOException ioException)
        {
            System.err.println("Can't read from the file.");
        }
        closeFile();
        return userlist;
    }
    
    public static user finduser(String un, String pwd){
        openFile();
        try
        {
            while (true) // loop until there is an EOFException
            {   
                user record = (user) myfile.readObject();
                String eun=record.getusername();
                String epwd=record.getpassword();
                if((eun.equals(un))&&(epwd.equals(pwd))){
                    record.printUser();
                    return record;
                }
            }
        }
        catch (EOFException endOfFileException)
        {
            System.out.printf("End of records%n");
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.err.println("Object is invalid.");
        }
        catch (IOException ioException)
        {
            System.err.println("Can't read from file");
        }
        closeFile();
        return new user();
    } 
    
    public static void closeFile()
    {
        try
        {
            if (myfile != null)
            myfile.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating.");
            System.exit(1);
        }
    }
    
}
