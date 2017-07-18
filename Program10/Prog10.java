import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.ByteBuffer;
/*=======================================================================================================================================
 |   Assignment:  Program #10: Binary Searching a Binary File
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  December 1st, 2015 9:00pm
 |
 |  Description:  This program gets from the command line a path to a file and a prefix of a name of a county. Using recursive binary
 |                search tries to find (or fails at) all counties within that file whose names begin with that prefix. When the name is
 |                found the program will display to the screen the complete name, state abbreviation, and population of each county
 |                starting with the given name prefix. If it was not found an error message is printed.
 |                
 | Operational :  Type in the file path and prefix to search for on the command line.
 | Requirements   
 |
 | Deficencies :  none
 |                
 *=====================================================================================================================================*/
public class Prog10
{
    public static void main (String [] args)
    {
        if (args.length < 2) // catches the user being a silly bunny
        {
            System.out.printf("Please enter on the command line: 'file directory' 'prefix to search for'\n");
            return;
        } // end silly games
        
        final String fileName = new String(args[0]); // file being inputted as it was supplied on the command line
        RandomAccessFile randyIn = null; // to hold the file as a RAF
        String prefix = args[1]; // the prefix being searched for
        int randyLength = 0; // to hold the length of the file title randy
        
        try
        {
            randyIn = new RandomAccessFile(fileName, "rw");
            randyLength = (int)randyIn.length();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        
        if (!searchForPrefix(0, randyLength-78, randyIn, prefix))
            System.out.printf("The prefix '%s' was not found. Sorry brother bear.\n", prefix);
        
    } // end main
    
    
    /*===================================================================================================================================
     |  Method Search For Prefix
     |
     |        Purpose: This method takes in the prefix that the user wants to search for in the file given. The other two parameters are
     |                 integer values representing the starting point of the first 'county' record and the end is the starting point of
     |                 the last 'county' record and this method searches between these two records. USES HELPER METHOD
     |
     |     Parameters: int start - the starting point of the first county record
     |                 int end - the starting point of the last county record
     |                 RandomAccessFile file - the file to be searched through for the county records
     |                 String prefix - the prefix to be on the lookout for!
     |
     |        Returns:  true/false - depending on if the searched worked or not
     *=================================================================================================================================*/
    public static boolean searchForPrefix(int start, int end, RandomAccessFile file, String prefix)
    {
        if (prefix.length() == 0) // base case if the prefix is empty
            System.out.printf("Please enter a prefix that isn't nothing.\n");
        else
            return searchForPrefix(start, end, 1, file, prefix);
        
        return true;
    } // end searchForPrefix
    
    
    
    /*===================================================================================================================================
     |  Method Search For Prefix
     |
     |        Purpose: This method takes in the prefix that the user wants to search for in the file given. The other two parameters are
     |                 integer values representing the starting point of the first 'county' record and the end is the starting point of
     |                 the last 'county' record and this method searches between these two records.
     |
     |     Parameters: int start - the starting point of the first county record
     |                 int end - the starting point of the last county record
     |                 int probeCount - the probecount
     |                 RandomAccessFile file - the file to be searched through for the county records
     |                 String prefix - the prefix to be on the lookout for!
     |
     |        Returns:  true/false - depending on if the searched worked or not
     *=================================================================================================================================*/
    public static boolean searchForPrefix(int start, int end, int probeCount, RandomAccessFile file, String prefix)
    {  
        int middle = (((start + end) / 78) / 2) * 78; // finds the middle of from the starting point of the first and starting point of the end
        int x = 14;                                   // integer that holds the starting 'byte' place of where the string begins
        int fileLength = 0;                          // to hold the byte size of the file
        int result = 0;
        byte[] b = new byte[78];                      // holds the entire 'county line' from the binary file
        byte[] name = new byte[64];                   // holds the country name
        
        // BASE CASE FOR FAILURE OF SEARCH
        if (end < start)                              // if end is greater than start the test has failed
            return false;
        
        // GENERAL CASE BELOW ALL THIS
        printProbe(start, end, probeCount, file);                // print the probes at the start of each search
        
        try
        {
            file.seek(middle);
            file.read(b);
            fileLength = (int)file.length();
        } // end try block 
        catch (IOException e) {e.printStackTrace();}
        
        for(int i = 0; i < 64; i++)
        {
            name[i] = b[x];
            x++;
        } // end for loop
        
        result = prefixInCounty(prefix, new String(name));
        
        
        if (result == 0)                                                // middle contains the prefix, began locating all records with this prefix
            return printCounties( middle, probeCount, fileLength, file, prefix);
        else if (result < 0)                                            // letters of lower value, check before the 'middle'
            return searchForPrefix(start, middle - 78, probeCount+1, file, prefix);
        else
            return searchForPrefix(middle + 78, end, probeCount+1, file, prefix);       // letters of greater value, check after the 'middle'
        
    } // end searchForPrefix
    
    
    
    /*===================================================================================================================================
     |  Method Print Counties
     |
     |        Purpose: This method takes in a location in the binary file that is also passed in and prints out all the county records
     |                 that contain the prefix that was passed in. This method itself only finds the starting record and last record,
     |                 it uses another helper method to actaully print out the records to avoid being too cluttered.
     |
     |     Parameters: int location - the location passed in that was located in the binary search
     |                 int fileLength - the byte size of the RAF file
     |                 RandomAccessFile file - the binary file
     |                 String prefix - the prefix being searched for
     |
     |        Returns: (none)
     *=================================================================================================================================*/
    private static boolean printCounties(int location, int probeCount, int fileLength, RandomAccessFile file, String prefix)
    {
        int start = location - 78;
        int end = location + 78;
        int result = 0; // holds the result if prefix inside county
        
        
        while (true)
        {
            byte[] b = new byte[78];                      // holds the entire 'county line' from the binary file
            byte[] name = new byte[64];                   // holds the country name
            int x = 14;
            
            
            try
            {
                file.seek(start);
                file.read(b);
                fileLength = (int)file.length();
            } // end try block 
            catch (IOException e) {e.printStackTrace();}
            
            for(int i = 0; i < 64; i++)
            {
                name[i] = b[x];
                x++;
            } // end for loop
            
            result = prefixInCounty(prefix, new String(name));
            
            if (result != 0 )
                break;
            
            
            start = start - 78;
        } // end while
        
        while (true)
        {
            byte[] b = new byte[78];                      // holds the entire 'county line' from the binary file
            byte[] name = new byte[64];                   // holds the country name
            int x = 14;
            
            try
            {
                file.seek(end);
                file.read(b);
                fileLength = (int)file.length();
            } // end try block 
            catch (IOException e) {e.printStackTrace();}
            
            for(int i = 0; i < 64; i++)
            {
                name[i] = b[x];
                x++;
            } // end for loop
            
            result = prefixInCounty(prefix, new String(name));
            
            if (result != 0 )
                break;
            
            
            end = end + 78;
        } // end while
        
        
        System.out.printf("\n\nThe counties whose letters are prefixed with '%s' are:\n", prefix);
        
        actuallyPrintCounties(start, end, file); // okay so this will actually print out the records
        
        System.out.printf("\nThe number of 'mid' records read was %d\n", probeCount);
        
        return true;
    } // end printCounties
    
    /*===================================================================================================================================
     |  Method Actually Print Counties
     |
     |        Purpose: Actually prints the counties. This time I'm not lying. Given the start and the end... also the file of course.
     |                 Uses for loops to store the bytes into bytes arrays and prints them at the end.
     |
     |     Parameters: int start - the starting point
     |                 int end - the start of the ending point
     |                 RandomAccessFile file - the file
     |
     |        Returns: (none)
     *=================================================================================================================================*/
    private static void actuallyPrintCounties(int start, int end, RandomAccessFile file)
    {
        System.out.printf("============================================\n");
        System.out.printf("State\tPopulation\t\tCounty\n");
        System.out.printf("============================================\n");
        
        
        for (int p = start + 78; p < end; p = p + 78)
        {
            byte[] b = new byte[78]; // to hold the entire record
            
            try
            {
                file.seek(p);
                file.read(b);
            }
            catch (IOException e){e.printStackTrace();}
            
            
            byte[] abrev = new byte[2];
            byte[] stateCode = new byte[4];
            byte[] countyCode = new byte[4];
            byte[] population = new byte[4];
            byte[] name = new byte[64];
            
            int x = 0;
            
            for(int i=0; i < 2; i++) // puts the state abbreviation in array
            {
                abrev[i] = b[i];
                x++;
            }
            
            x+=8;
            
            for(int i = 0; i < 4; i++) // puts population in array
            {
                population[i] = b[x];
                x++;
            }
            
            for(int i = 0; i < 64; i++) // puts name in byte array
            {
                name[i] = b[x];
                x++;
            }
            
            
            System.out.printf("%s\t%d\t\t%s\n", new String(abrev), ByteBuffer.wrap(population).getInt(), new String(name));
            
        } // end for loop
        
    } // end actuallyPrintCounties
    
    
    /*===================================================================================================================================
     |  Method Prefix In County?
     |
     |        Purpose: This method takes in the prefix that is being searched for as well as the the current county to see if this
     |                 prefix exists inside this county name. The method returns 0 if it does exists inside the name, a negative value
     |                 if the character at the index where they differ is of lower ASCII value, and a positive if the ASCII value of the
     |                 different character is positive.
     |
     |     Parameters: String prefix - the prefix to look for inside the county
     |                 String county - the county to be looked into by the prefix
     |
     |        Returns:  -1 / 0 / 1 (depending on the result)
     *=================================================================================================================================*/
    public static int prefixInCounty(String prefix, String county)
    {
        prefix = prefix.toUpperCase(); // puts the prefix and county in uppercase for easier ASCII comparisons
        county = county.toUpperCase();
        
        int maxIndex = 0; // holds the length of the shorter string to avoid going out of bounds
        
        if (prefix.length() < county.length())
            maxIndex = prefix.length();
        else
            maxIndex = county.length();
        
        
        
        for (int i = 0; i < maxIndex; i++)
        {
            if (prefix.charAt(i) < county.charAt(i)) // lower ASCII value
                return -1;
            else if (prefix.charAt(i) > county.charAt(i)) // higher ASCII value
                return 1;
        } // end for loop
        
        
        return 0; // prefix IS inside the county. true.
    } // false
    
    
    
    
    /*===================================================================================================================================
     |  Method Print Probe
     |
     |        Purpose: This method takes in the starting point and ending point to search in a binary file and prints out what the high,
     |                 med, and low of this file at these indicies is. These probes are essential for debugging purposes and for just overall
     |                 tracking of how the program executed.
     |
     |     Parameters: int start - the starting point of the first 'county'
     |                 int end - the starting point of the last 'county'
     |                 RandomAccessFile file - the binary file to be searching through
     |
     |        Returns:  (none)
     *=================================================================================================================================*/
    public static void printProbe(int start, int end, int probeCount, RandomAccessFile file)
    {
        int middle = (((start + end) / 78) / 2) * 78;
        int x = 14; // starts at 14 since thats when the bytes containing teh string begins
        
        byte[] b = new byte[78]; // to hold the bytes of this county
        byte[] name = new byte[64]; // to hold just the name this county
        
        
        System.out.printf("Probe #%d:", probeCount);
        
        
        ///////////////////////////////////////// Prints the low
        try
        {
            file.seek(start);
            file.read(b);
        }
        catch (IOException e){e.printStackTrace();}
        for(int i = 0; i < 64; i++)
        {
            name[i] = b[x];
            x++;
        }
        System.out.printf("\tLow:\t%d\t(%s)\n", start / 78, new String(name));
        ////////////////////////////////////////////////////////////
        
        
        
        
        ////////////////////////////////////////// Prints the med
        try
        {
            file.seek(middle);
            file.read(b);
        }
        catch (IOException e){}
        x = 14; // reset to 14 since the string begins here
        for (int i = 0; i < 64; i++)
        {
            name[i] = b[x];
            x++;
        }
        System.out.printf("\tMid:\t%d\t(%s)\n", middle / 78, new String(name));
        ////////////////////////////////////////////////////////////
        
        

        ////////////////////////////////////////// Prints the end
        try
        {
            file.seek(end);
            file.read(b);
        }
        catch (IOException e){}
        x = 14; // reset to 14 since the string begins here
        for (int i = 0; i < 64; i++)
        {
            name[i] = b[x];
            x++;
        }
        System.out.printf("\tHigh:\t%d\t(%s)\n", end / 78, new String(name));
        //////////////////////////////////////////////////
        
        System.out.printf("\n");
    } // end printProbe
    
    
} // end class