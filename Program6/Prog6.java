import java.io.*;
import java.util.*;
/*=======================================================================================================================================
 |   Assignment:  Program 6: A-Mazeing
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  October 22, 2015 9:00pm
 |
 |  Description:  This program generates a random maze given the rows and columns from the user.
 |                
 | Operational :  Dr.Java-20140826-r5761
 | Requirements   User must supply two integers on the command line for the program to run.
 |
 | Deficencies :  The printing of the maze in the output window doesn't properly draw the lines.
 |
 |                
 *=====================================================================================================================================*/
class Prog6
{
    public static void main(String [] args)
    {
        int r = 0; // number of rows given by the user
        int c = 0; // number of columns given by the user
        
        
        try
        {
            r = Integer.parseInt(args[0]);
            c = Integer.parseInt(args[1]);
        }
        catch(ArrayIndexOutOfBoundsException e) // if no arugments given
        {
            System.out.print("Enter at least two integers on the command line for the rows and columns\n");
            return;
        }
        catch(NumberFormatException e) // if no plausible numbers were given by the user
        {
            System.out.print("This program requires that two integers(row, columns) be entered on the command\n"+
                             "line to generate a random maze.");
            return;
        } // end TRY / CATCH

        
        
        MazeHolder theMaze = new MazeHolder(r,c);
        System.out.println(); 
        theMaze.createMaze(); // creates the maze
        theMaze.drawMaze(); // draw that maze young blood
        


        
    } // end main
} // end class