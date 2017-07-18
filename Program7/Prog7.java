/*=======================================================================================================================================
 |   Assignment:  Program #7: Boundary Fill
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  October 29, 2015 9:00pm
 |
 |  Description:  This program takes in a file specified by the user that contains a figure, a starting point, and a char for filling.
 |                This program goes through the figure and replaces each itteration of the char at the starting point and replaces it
 |                with the filling char until it touches a border. Works much like MS Paint's "bucket" tool.
 |                
 | Operational :  Dr.Java-20140826-r5761
 | Requirements   User must supply the filename, starting x val, starting y val, and filling char on the command line otherwise the 
 |                program will ask the user to supply these things.
 |
 | Deficencies :  none
 |
 |                
 *=====================================================================================================================================*/
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prog7
{
    private static int numRows; // holds the number of rows from the file read in
    private static int numCols; // holds the number of columns from the file read in
    
    public static void main (String [] args)
    {
        BufferedReader scanIn = null; // temporarily holds the what user enters on the keyboard
        Point start = null; // holds the point of beginning
        String filename = null; // holds the filename
        String tempStr = null;
        char filling = ' '; // holds the character to be used for filling
        char [][] figure;
        int x = -1;
        int y = -1;
        
        
        if (args.length < 4)
        {
            System.out.println("Enter the name of the image file: ");
            scanIn = new BufferedReader(new InputStreamReader(System.in));
            try{filename = scanIn.readLine();}catch(IOException e){}
            
            System.out.println("Enter the row,col starting location of the fill area, comma-separated: ");
            scanIn = new BufferedReader(new InputStreamReader(System.in));
            try{tempStr = scanIn.readLine();}catch(IOException e){}
            
            for(int i = 0; i < tempStr.length(); i++)
            {
                if (tempStr.charAt(i) == ',')
                {
                    x = Integer.parseInt(tempStr.substring(0,i));
                    y = Integer.parseInt(tempStr.substring(i+1, tempStr.length()));
                    break;
                } // end the good ol if statement my brothers let us drink until our bellys cannot no longer
            } // end for
            
            System.out.println("Enter the character to be used for filling surrounded by quotation marks: ");
            scanIn = new BufferedReader(new InputStreamReader(System.in));
            try{tempStr = scanIn.readLine();}catch(IOException e){}
            filling = tempStr.charAt(0);
        } // end if
        else if (args.length == 4)
        {
            filename = args[0];
            x = Integer.parseInt(args[1]);
            y = Integer.parseInt(args[2]);
            String args3 = args[3];
            filling = args3.charAt(0);
            System.out.print(filling);
        } // end else
        
        start = new Point(x,y);
        // // // // // // LETS GET STARTED // // // // // // //
        
        figure = readInFile(filename); // reads in the file and assigns it to a 2D char array
        displayOriginal(figure, start, filling); // displays the origianl image, the location, char at the start location, & new char for filling
        boundaryFill(figure, start, filling);
        
        
        
        
    } // end main
    
    
    /*===================================================================================================================================
     |  Method readInFile
     |
     |        Purpose: Reads in the file line by line and assigns each individual character to a 2D character array 'figure'.
     |
     |     Parameters: String filename - the name of the file the figure will be read from
     |
     |    Pre-Condition: file is passed in and will be transposed into a char array of two dimensions
     |   Post-Condition: 2D char array is returned that contains the info of the file
     |
     |        Returns:  char figure[][] - the file as a 2D char array
     *=================================================================================================================================*/
    public static char[][] readInFile(String filename)
    {
        BufferedReader file = null; // the file
        char[][] figure = null;     // holds the figure as a 2D array
        String line = "";           // to hold the line of the file currently being looked at
        numRows = 0;            
        numCols = 0;
        
        try 
        {
            file = new BufferedReader(new FileReader(filename)); 
            line = file.readLine(); // reads in the file line that contains the # of rows and cols
            
            for(int i = 0; i < line.length(); i++)
            {
                if (line.charAt(i) == ' ') // ONLY WORKS IF THERE IS ONE SPACE BETWEEN NUMBERS. FIX LATER IF NECCESARY
                {
                    numRows = Integer.parseInt(line.substring(0,i)); // assigns the first number to rows
                    numCols = Integer.parseInt(line.substring(i+1, line.length())); // second number is the columns
                    break;
                } // end the good ol if statement my brothers let us drink until our bellys cannot no longer
            } // end for
            
            
            figure = new char[numRows][numCols]; // char array that holds the data of the file read in
            
            
            int i = 0;
            while ((line = file.readLine()) != null) // while the file has a line increment counter
            {
                figure[i] = line.toCharArray();
                i++;
            } // end while loop
            
            
            if (!(i == numRows && figure[0].length == numCols)) // if the two integers at the top of the file are incorrect
            {
                numRows = i;
                numCols = figure[0].length;
            } // end if  - that reassigns numRows and numCols to the correct values
            
            
            file.close();
        } // end try block
        catch (FileNotFoundException e) 
        {
            System.out.printf("File \"%s\" was not found. Please try again!\n", filename);
            System.exit(0);
        }
        catch (IOException e)
        {
            e.getClass().getName();
        } // end catch bruh
        
        
        
        return figure;
    } // end readInFile
    
    
    /*===================================================================================================================================
     |  Method displayOriginal
     |
     |        Purpose: Displays the figure that was read in from the file from the 2D char array figure. Prints the starting location as
     |                 given by the user and the current character at the location (i.e. the character that will become over written
     |                 in the methods to come with the boundary filling algoirthm). Finally, prints the char that will be the "filler"
     |                 or the overrider of the char at the starting location. Lets get ready for a great night of fun.
     |
     |     Parameters: char[][] figure - the figure read from the text file as a 2D char array
     |                 Point start - the starting point which also holds the char that will get overridden
     |                 char filling - the filler char
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Just printing is done. Nothing is actually modified.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public static void displayOriginal(char[][] figure, Point start, char filling)
    {
        int startX = (int)start.getX(); // holds the x value
        int startY = (int)start.getY(); // holds the y value
        
        for(int i = 0; i < figure.length; i++) // prints the figure line by line
            System.out.println(figure[i]);
        
        
        System.out.println("\nThe starting location will be ("+startX+", "
                               +startY+") with the char \""+figure[startX][startY]+"\" at that location.");
        System.out.println("The character that will be used for filling is the humble \""+filling+"\" character. What a champ!\n");
    } // end displayOriginal
    
    
    /*===================================================================================================================================
     |  Method boundaryFill
     |
     |        Purpose: Assumed one knows what the variables mean by now. This method begins at the starting point and replaces all the
     |                 target variables touching that pixel line (horizontal line). As it's going through replacing the target variable
     |                 it checks to see if there are target variables above and below. If so, those points are added to the queue and the
     |                 same process is ran again. This acts much like the "bucket" function in MS Paint. As long as there are no other
     |                 variables or "borders" all the target variables are change to the filling specified by the user.
     |
     |     Parameters: char[][] figure - the figure read from the text file as a 2D char array
     |                 Point start - the starting point which also holds the char that will get overridden
     |                 char filling - the filler char
     |
     |    Pre-Condition: figure currently holds the 
     |   Post-Condition: Just printing is done. Nothing is actually modified.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public static void boundaryFill(char[][] figure, Point start, char filling)
    {
        Point currentPoint = null;      // will contain the current point of overridding
        int startX = (int)start.getX(); // holds the starting x value
        int startY = (int)start.getY(); // holds the starting y value
        int currentPointX = 0;          // contains the current point's x value
        int currentPointY = 0;          // contains the current point's y value
        int leftMostX = 0;              // will temporaily contain the left most x value
        int pixelSpansCount = 0;        // will contain the number of pixel spans filled
        int pixelsCount = 0;            // will contain the number of pixels modified
        char targetChar = figure[startY][startX]; // holds the target char to get overridden
        
        
        
        // FIX ME ME ME
        CS127BQueue fillingQueue = new CS127BQueue(numRows * numCols); // queue object created with maximum of points in figure
        // FIX THE QUEUE SIZE NEEDS TO BE ABLE TO GROW, NOT ALWAYS THE BIGGEST MOTHER TRUCKER IN THE WORLD YOU SILLY WILLY BILLY 
        
        fillingQueue.enqueue(start); 
        
        while (!(fillingQueue.isEmpty()))
        {
            System.out.println("\nQueue:");
            fillingQueue.printQueue();
            System.out.println("");
            
            currentPoint = fillingQueue.dequeue(); // the current point is ready for searching and overridding
            currentPointX = (int)currentPoint.getX(); // the point x is also an int for faster typing and readability
            currentPointY = (int)currentPoint.getY(); // the point y is also an int for faster typing and readability
            
            
            for (int i = currentPointX; i >= 0; i--) // loop that finds the left most char 
            {
                if (i == 0 || figure[currentPointY][i - 1] != targetChar)
                {
                    leftMostX = i;
                    break;
                } // end if
            } // end for loop
            
            
            // now that we have the left most char we can start the fun stuff! (overridding)
            for (int i = leftMostX; figure[currentPointY][i] == targetChar; i++)
            {
                if (currentPointY != 0 && figure[currentPointY - 1][i] == targetChar) // checks above the current point for targetChar
                {
                    Point enqueuePoint = new Point(i, currentPointY - 1);
                    fillingQueue.enqueue(enqueuePoint);
                } // end if
                
                if (currentPointY != numRows - 1 && figure[currentPointY + 1][i] == targetChar) // checks below the current point for targetChar
                {
                    Point enqueuePoint = new Point(i, currentPointY + 1);
                    fillingQueue.enqueue(enqueuePoint);
                } // end if
                
                figure[currentPointY][i] = filling;
                pixelsCount++; // increment # of pixels filled
                
                
            } // end for loop
            
            pixelSpansCount++; // increment # of pixel spans filled
        } // end while
        
        printEnd(figure, pixelSpansCount, pixelsCount); // method that prints the find figure
        
        
    } // end boundaryFill
    
    
    /*===================================================================================================================================
     |  Method printEnd
     |
     |        Purpose: Simply prints the resulting figure with the filling char replacing the target chars based on the algorithm.
     |
     |     Parameters: char[][] figure - the figure read from the text file as a 2D char array
     |                 pixelSpansCount - (self-explanatory)
     |                 pixelsCount - (same)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public static void printEnd(char[][] figure, int pixelSpansCount, int pixelsCount)
    {
        System.out.print("\n=======================================================================================================\n");
        
        for(int i = 0; i < figure.length; i++) // prints the figure line by line
            System.out.println(figure[i]);
        
        System.out.print("=========================================================================================================\n");
        System.out.printf("Pixels Modified: %d \t Pixel Spans Modified: %d\n", pixelsCount, pixelSpansCount);
    } // end printEnd
    
} // end class