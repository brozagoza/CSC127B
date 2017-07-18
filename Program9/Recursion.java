/*=================================================================================================================================*
 ||
 ||  Class Recursion 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class is simply several Recursion methods that allow us to practice using this
 ||                  new concept introduced in class by the man, McCann.
 ||
 ||  Inherits From:  None
 ||
 ||     Interfaces:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  None
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  gcd (int x, int y)
 ||                  ackermann (int x, int y)
 ||                  reverse (String str)
 ||                  rangeSum (double [] array, int lower, int upper)
 ||                  pascalRow (int row)
 ||                  
 ||
 =================================================================================================================================*/
class Recursion
{
    /*===================================================================================================================================
     |  Method Greatest Common Divisor
     |
     |        Purpose: Finds the greatest common divisor between two numbers that are passed in. This method uses recursion as it calls
     |                 itself until a zero is passed in, the x value at that instance is the GCD.
     |
     |     Parameters: int x - number
     |                 int y - number
     |
     |        Returns:  Greatest Common Divisor as an int
     *=================================================================================================================================*/
    public static int gcd (int x, int y)
    {
        if (y != 0)
            return gcd(y, x%y);
        else
            return x;
    } // end gcd
    
    /*===================================================================================================================================
     |  Method Ackermann's Function
     |
     |        Purpose: This recursion performs Acerkmann's function that was presetned origianlly in 1928. 
     |
     |     Parameters: int x - number
     |                 int y - number
     |
     |        Returns:  ackermann's number
     *=================================================================================================================================*/
    public static int ackermann (int m, int n)
    {
        if (m == 0)
            return n + 1;
        else if (m > 0 && n == 0)
            return ackermann(m-1, 1);
        else
            return ackermann(m-1, ackermann(m, n-1));
    } // end ackermann
    
    /*===================================================================================================================================
     |  Method String Reversal
     |
     |        Purpose: Given a new string, returns a new string in reverse.
     |
     |     Parameters: String str - the string that is passed in
     |
     |        Returns: returns the string in reverse
     *=================================================================================================================================*/
    public static String reverse (String str)
    {
        if (str.length() == 0)
            return str;
        else
            return reverse(str.substring(1, str.length())) + str.charAt(0);
        
    } // end reverse
    
    /*===================================================================================================================================
     |  Method Range Sum
     |
     |        Purpose: Given an array of doubles and two indices in the array, returns the sum of teh array from lower
     |                 to upper index.
     |
     |     Parameters: int x - number
     |                 int y - number
     |
     |        Returns:  Greatest Common Divisor as an int
     *=================================================================================================================================*/
    public static double rangeSum (double [] array, int lower, int upper)
    {
        
        if (lower == upper)
            return array[lower];
        else if (lower > upper)
            return 0;
        else if (lower + 1 == upper)
            return array[lower] + array[upper];
        else
            return array[lower] + array[upper] + rangeSum(array, lower+1, upper-1);

    }// rangeSum
    
    /*===================================================================================================================================
     |  Method Pascal's Triangle
     |
     |        Purpose: Accepts a row index and returns an array of int that contains that row of the triangle, starting
     |                 at index 0 of the array. This is a recursive method.
     |
     |     Parameters: int row - 
     |
     |        Returns: 
     *=================================================================================================================================*/
    public static int [] pascalRow (int row)
    {
        int[] theRow = new int[row+1];
       
        if(row == 0)
       {
           theRow[0] = 1;
           return theRow;
       }
       else if (row == 1)
       {
           theRow[0] = 1;
           theRow[1] = 1;
           return theRow;
       }
       else
       {
           int[] aboveRow = pascalRow(row-1);
           theRow[0] = 1;
           theRow[row] = 1;
           
           for(int i = 1; i < row; i++)
           {
               theRow[i] = aboveRow[i-1] + aboveRow[i];
           }
           
           return theRow;
       }
        
        
    } // end pascalRow
    
    /*===================================================================================================================================
     |  Method Horse Ride
     |
     |        Purpose: Accepts a row index and returns an array of int that contains that row of the triangle, starting
     |                 at index 0 of the array. This is a recursive method.
     |
     |     Parameters: int row - 
     |
     |        Returns: 
     *=================================================================================================================================*/
    public static void horseRide (int [][] board, int row, int col)
    {
        
    } // end horseRide
} // end Recursion