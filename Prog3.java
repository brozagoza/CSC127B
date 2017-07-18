import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/*=======================================================================================================================================
 |   Assignment:  Program #3: Word Count
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  September 24, 2015 9:00pm
 |
 |  Description:  This program counts lines, words, and bytes (characters) of text files. Much like 'wc' on UNIX systems, but with an 
 |                improved output. If no readable files are given to the program, then useful information is passed to the user to
 |                re-run with better results. Any number of files may be passed into this program.
 |                
 | Operational :  Dr.Java-20140826-r5761
 | Requirements   User must supply the name of the file on the command line, as 'wc' expects or the program will prompt the user to enter
 |                the file name(s) on the keyboard.
 |
 | Deficencies :  none
 |
 |                
 *=====================================================================================================================================*/
public class Prog3 {
    public static void main (String [] args)
    {
        int fileCount = 0;                // amount of files entered
        int[][] counts;                   // array to hold the counts of lines, words, and bytes of each file
        String[] files = null;            // creates an array of the amount of files being inputed
        BufferedReader scanIn = null;     // the text from the user that is "scanned" in when no cmnd-line args given
        String scanInStr = "";            // the text from 'scanIn' that is in string form
        
        
        
        
        if (args.length > 0) // if user entered file names on command line
        {
            fileCount = fileCounter(args, scanInStr); // number of files 
            
            files = new String[fileCount]; // creates an array of the amount of files being inputed
            
            for (int i = 0; i < fileCount; i++)
                files[i] = args[i];
            
        } // end if
        
        else // user will enter file names with bufferedreader
        {
            System.out.printf("This program determines the quantity of lines, words, and bytes\n");
            System.out.printf("in a file or files that you specify.\n\n");
            System.out.printf("Please enter one or more file names, comma-seperated:");
            scanIn = new BufferedReader(new InputStreamReader(System.in));
            
            try{scanInStr = scanIn.readLine();}catch(IOException e){}
            
            
            fileCount = fileCounter(args, scanInStr); // number of files
            
            
            files = scanInStr.split("\\,"); // splits the string from the point of the comma
            
            for (int i = 0; i < fileCount; i ++) // discards uneccessary whitespace among file arguments
                files[i] = files[i].trim();
            
        } // end else
        
        
        counts = new int[fileCount][3]; // array to hold the counts of the files (0-lines, 1-words, 2-bytes)
        
        
        
        
        for (int i = 0; i < fileCount; i++)
        {
            counts[i][0] = countLines(files[i]);
            if (counts[i][0] == -1) return; // terminate program if not found

            counts[i][1] = countWords(files[i]);
            if (counts[i][0] == -1) return; // terminate program if not found
            
            counts[i][2] = countBytes(files[i]);
            if (counts[i][0] == -1) return; // terminate program if not found
            
        } // end for loop
        

        printResults(counts, fileCount, files);
        
        
    } // end main
    
    
    
    /*===================================================================================================================================
     |  Method fileCounter
     |
     |        Purpose: Goes through the arguments that were passed in and counts the amount of files that the user has supplied. Whether
     |                 it be from the command line or through a bufferedreader object, this program should return the total number of
     |                 files that were passed in.
     |
     |     Parameters: String[] args - arguments typed in on the command line
     |                 String scanInStr - arugments typed in after the command line
     |
     |    Pre-Condition: The file will not be altered and will contain what it was passed in with.
     |   Post-Condition: File's value has not chnaged because this method does not alter anything.
     |
     |        Returns:  fileCOunt - the number of files in the arguments
     *=================================================================================================================================*/ 
    public static int fileCounter(String[] args, String scanInStr)
    {
        int fileCount = 0;
        
        
        if (args.length > 0)
            return args.length;
        else
        {
            for (int i = 0; i < scanInStr.length(); i++)
            {
                if (scanInStr.charAt(i) == ',')
                    ++fileCount;
            } // end for loop
            
            ++fileCount;
            
        } // end else
        
        return fileCount;
    } // end fileCounter
    
    
    
    
    /*===================================================================================================================================
     |  Method countLines
     |
     |        Purpose: Goes through the file and counts the amount of "lines" found using a while loop to perform this action. The count
     |                 is then returned as a interger value.
     |
     |     Parameters: String file - the file being passed in to be counted
     |
     |    Pre-Condition: The file will not be altered and will contain what it was passed in with.
     |   Post-Condition: File's value has not chnaged because this method does not alter anything.
     |
     |        Returns:  count - the number of lines in the file
     *=================================================================================================================================*/ 
    public static int countLines(String input)
    {
        int count = 0;
        BufferedReader file = null;

        try 
        {
            file = new BufferedReader(new FileReader(input));
        }
        catch (FileNotFoundException e) 
        {
            System.out.printf("File \"%s\" was not found. Please try again!\n", input);
            System.out.printf("This program reads in file(s) and returns the number of lines, words, and bytes conatined.\n");
            System.out.printf("The user should supply usable file names on the command line or once the program runs.\n");
            return -1;
        }
        
        
        
        try 
        {
            String line = null;
            while ((line = file.readLine()) != null) // while the file has a line increment counter
                ++count;
        } 
        catch (IOException e)
        {
            e.getClass().getName();
        } // end catch bruh
        
        return count;
    } // end countLines
    
    
    
    
    
    /*===================================================================================================================================
     |  Method countWords
     |
     |        Purpose: Goes through the file and counts the number of words in the file. This program goes through each line as a string
     |                 and counts the white space. This program also accounts for new lines and doesn't count those white spaces as such.
     |
     |     Parameters: String file - the file being passed in to be counted
     |
     |    Pre-Condition: The file will not be altered and will contain what it was passed in with.
     |   Post-Condition: File's value has not chnaged because this method does not alter anything.
     |
     |        Returns:  count - the number of words in the file
     *=================================================================================================================================*/ 
    public static int countWords(String input)
    {
        int count = 0;
        BufferedReader file = null;
        
        
        
        try 
        {
            file = new BufferedReader(new FileReader(input));
        }
        catch (FileNotFoundException e) 
        {
            System.out.printf("File \"%s\" was not found. Please try again!\n", input);
            System.out.printf("This program reads in file(s) and returns the number of lines, words, and bytes conatined.\n");
            System.out.printf("The user should supply usable file names on the command line or once the program runs.\n");
            return -1;
        }
        
        try
        {
            
            String line = null;
            while( (line = file.readLine()) != null)
            {
                line = line.trim(); // lets get rid of any trailing white space shall we big boys alright thats what i wanna hear
                
                if (line.length() != 0 ) // as long as the line being read isn't just whitespace NEEDS FIX FOR EMPTY SPACESSSSSS
                {
                    for(int i = 0; i < line.length(); i++)
                    {
                        if (line.charAt(i) == 32) // if there is a space (' ') increment word counter
                            ++count;
                        
                    } // end for loop
                    
                    ++count; // assume there is a word at the end of every line that isn't blank
                    
                } // end if
                
            } // end while loop
            
            
        } // end try block
        catch (IOException e)
        {
            e.getClass().getName();
        } // end catch again bruh
        
        return count;
    }
    
    
    
    
    /*===================================================================================================================================
     |  Method countBytes
     |
     |        Purpose: Goes through the file and counts the amount of bytes found using the File class. To count the bytes of the file
     |                 the file is passed in using the File class and followed by the File.length() method
     |
     |     Parameters: String file - the file being passed in to be counted
     |
     |    Pre-Condition: The file will not be altered and will contain what it was passed in with.
     |   Post-Condition: File's value has not chnaged because this method does not alter anything.
     |
     |        Returns:  count - the number of lines in the file
     *=================================================================================================================================*/ 
    public static int countBytes(String input)
    {
        int count = 0; // to hold the count of bytes
        File file = null;
        
        
        try 
        {
            file = new File(input);
        } 
        catch(Exception e)
        {
            e.getClass().getName();
        } // okay heres another catch that must come to a conclusion... bruh
        
        count = (int)file.length(); // casts length(byte size) of the file as int
        
        return count;
    } // end countBytes
    
    
    
    
    
    /*===================================================================================================================================
     |  Method printResults
     |
     |        Purpose: Simply receives the counts of the files passed in as well as the total fileCount and the file names. This method
     |                 prints out this data that is received to match the output requirements stated in the handout.
     |
     |     Parameters: int[][] counts - the total counts of each of the files
     |                 int fileCount - total number of files entered
     |                 String[] files - the files that were origianlly passed in
     |
     |    Pre-Condition: The files will not be altered and will contain what it was passed in with.
     |   Post-Condition: File's value has not chnaged because this method does not alter anything.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public static void printResults(int[][] counts, int fileCount, String[] files)
    {
        int[] totals = new int[3];
        totals[0] = 0; // total lines
        totals[1] = 0; // total words
        totals[2] = 0; // total bytes
        
        
        System.out.printf("%8s\t%8s\t%8s\n", "Lines", "Words", "Bytes");
        System.out.printf("--------\t--------\t--------\n");
        
        
        for (int i = 0; i < fileCount; i++)
        {
            System.out.printf("%8d\t%8d\t%8d\t%s\n", counts[i][0], counts[i][1], counts[i][2], files[i]);
            totals[0]+=counts[i][0];
            totals[1]+=counts[i][1];
            totals[2]+=counts[i][2];
        } // end for
        
        if (fileCount > 1)
        {
            System.out.printf("-------------------------------------------\n");
            System.out.printf("%8d\t%8d\t%8d\n", totals[0], totals[1], totals[2]);
        }
        
        
    } // end PrintResults
    
} // end class