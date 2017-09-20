package controller;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.quiz;

public class quizhandling {

	 private static ObjectInputStream input;
	    
	    public static void openFile(){
	        try // open file
	        {
	            input = new ObjectInputStream(Files.newInputStream(Paths.get("quizzes.ser")));
	        }    
	        catch (IOException ioException)
	        {
	           System.err.println("Error opening file.");
	           System.exit(1); 
	        }
	    }
	    
	    public static List readRecords(){
	        List<quiz> qlist=new ArrayList();
	        openFile();
	        try
	        {
	            while (true) // loop until there is an EOFException
	            {   
	                qlist.add((quiz) input.readObject());
	            }
	        }
	        catch (EOFException endOfFileException)
	        {
	            System.out.printf("No more records%n");
	        }
	        catch (ClassNotFoundException classNotFoundException)
	        {
	            System.err.println("Invalid object type. Terminating.");
	        }
	        catch (IOException ioException)
	        {
	            System.err.println("Error reading from file. Terminating.");
	        }
	        closeFile();
	        return qlist;
	    }
	    
	    public static quiz readRecord(String title){
	        openFile();
	        try
	        {
	            while (true) // loop until there is an EOFException
	            {   
	                quiz record = (quiz) input.readObject();
	                String tt=record.gettitle();
	                if(tt.equals(title)){
	                    return record;
	                }
	            }
	        }
	        catch (EOFException endOfFileException)
	        {
	            System.out.printf("No more records%n");
	        }
	        catch (ClassNotFoundException classNotFoundException)
	        {
	            System.err.println("Invalid object type. Terminating.");
	        }
	        catch (IOException ioException)
	        {
	            System.err.println("Error reading from file. Terminating.");
	        }
	        closeFile();
	        return new quiz();
	    } // end method readRecords
	    
	    public static void closeFile()
	    {
	        try
	        {
	            if (input != null)
	            input.close();
	        }
	        catch (IOException ioException)
	        {
	            System.err.println("Error closing file. Terminating.");
	            System.exit(1);
	        }
	    }
	}

