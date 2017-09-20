package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import model.user;

public class userhandlingadd {

	 private static ObjectOutputStream output; // outputs data to file
	    
	    public static void openFile()
	    {
	        try
	        {
	            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("users.ser")));
	        }
	        catch (IOException ioException)
	        {
	            System.err.println("Error opening file. Terminating.");
	            System.exit(1); // terminate the program
	        }
	    }
	    
	    public static void closeFile()
	    {
	        try
	        {
	            if (output != null)
	            output.close();
	        }
	        catch (IOException ioException)
	        {
	            System.err.println("Error closing file. Terminating.");
	        }
	    }

	    public static void savePreviousRecords(){
	        List<user> savedusers=new ArrayList();
	        savedusers=userhandling.readRecords();
	        Iterator itr=savedusers.iterator();
	        openFile();
	        while(itr.hasNext()){
	            try
	            {
	                // create new record; this example assumes valid input
	                user usr =(user)itr.next();
	                // serialize record object into file
	                output.writeObject(usr);
	                System.out.printf("%s\t%s\t%s",usr.getusername(),usr.getpassword(),usr.getrole());
	            }
	            catch (NoSuchElementException elementException)
	            {
	                System.err.println("Invalid input. Please try again.");
	            }
	            catch (IOException ioException)
	            {
	                System.err.println("Error writing to file. Terminating.");
	            }
	        }
	    }


	public static void addRecordStudent(String userName, String password, String role, int score)
	    {
	        savePreviousRecords();
	        try
	        {
	            // create new record; this example assumes valid input
	            user usr = new user(userName, password, role, score);
	            // serialize record object into file
	            output.writeObject(usr);
	        }
	        catch (NoSuchElementException elementException)
	        {
	            System.err.println("Invalid input. Please try again.");
	        }
	        catch (IOException ioException)
	        {
	            System.err.println("Error writing to file. Terminating.");
	        }
	        closeFile();
	    }

	    
//	    public static void addRecordStudent(String userName, String password, String role, int score)
//	    {
//	        openFile();
//	        try
//	        {
//	            // create new record; this example assumes valid input
//	            User usr = new User(userName, password, role, score);
//	            // serialize record object into file
//	            output.writeObject(usr);
//	        }
//	        catch (NoSuchElementException elementException)
//	        {
//	            System.err.println("Invalid input. Please try again.");
//	        }
//	        catch (IOException ioException)
//	        {
//	            System.err.println("Error writing to file. Terminating.");
//	        }
//	        closeFile();
//	    }
	    
	     public static void addRecordInstructor(String userName, String password, String role)
	    {
	        savePreviousRecords();
	        try
	        {
	            // create new record; this example assumes valid input
	            user usr = new user(userName, password, role);
	            // serialize record object into file
	            output.writeObject(usr);
	        }
	        catch (NoSuchElementException elementException)
	        {
	            System.err.println("Invalid input. Please try again.");
	        }
	        catch (IOException ioException)
	        {
	            System.err.println("Error writing to file. Terminating.");
	        }
	        closeFile();
	    }
	    
	}

