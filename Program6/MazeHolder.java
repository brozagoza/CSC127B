import java.io.*;
import java.util.*;
/*=================================================================================================================================*
 ||
 ||  Class MazeHolder 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  
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
 ||   Constructors:  MazeHolder(int r, int c)
 ||
 ||  Class Methods:  createMaze()
 ||                  drawMaze()
 ||                  checkNorth()
 ||                  checkSouth()
 ||                  checkWest()
 ||                  checkEast()
 ||
 ||  Inst. Methods:  
 ||
 =================================================================================================================================*/
class MazeHolder
{
    private char [][] maze; // 2D array to hold the maze as a character representation
    private Stack mazeStackRows; // stack that holds the row coordinates that have been used
    private Stack mazeStackCols; // stack that holds the column coordinates that have been used
    private int numRows; // number of rows in this maze
    private int numCols; // number of columns in this maze
    private int inR;
    private int inC;
    
    
    /*===================================================================================================================================
     |  Constructor MazeHolder
     |
     |        Purpose: Declares the maze object to as a 2D array  with rows and columns sized based on the layout of the handout.
     |              
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Object created!
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public MazeHolder(int r, int c)
    {
        inR = r;
        inC = c;
        
        numRows = (2*r)+1;
        numCols = (2*c)+1;
        
        maze = new char[numRows][numCols]; // declares the array given rows and columns
        mazeStackRows = new Stack();
        mazeStackCols = new Stack();
        
        
        for (int i = 0; i < numRows; i++) // initially sets all characters in the array to '#'
            for (int j = 0; j < numCols; j++)
            maze[i][j] = '#';
        
    } // end constructor
    
    
    /*===================================================================================================================================
     |  Method createMaze()
     |
     |        Purpose: Creates a maze by (2r+1) by (2c+1) dimensions. The openings of the maze are randomly genereated using a random
     |                 object. The entrance is a random location on the left border and the exit is a random location on the right 
     |                 border.
     |              
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: character array will used to generate random openings
     |   Post-Condition: Maze should consists of possible paths to reach an eventual exit.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public void createMaze()
    {
        Random randy = new Random(); // Random object
        int[] startLocation = new int[2]; // array to hold the starting location of the maze
        startLocation[0] = 2;
        startLocation[1] = 2;
        int entrance = 0; // to hold the value of where the maze starts
        int exit = 0; // '' end
        
        
        
        while(startLocation[0] % 2 == 0 || startLocation[1] % 2 == 0)
        {
            startLocation[0] = randy.nextInt( numRows - 2 ) + 1 ; // the starting row # not including the borders
            startLocation[1] = randy.nextInt( numCols - 2 ) + 1; // the starting col #
        }
        
        mazeStackRows.push(startLocation[0]); // push the starting location onto the stacks; gold the row value
        mazeStackCols.push(startLocation[1]); // holds the column value
        maze[startLocation[0]][startLocation[1]] = ' '; // replace the # with a space
        
        
        //System.out.print("the start is ("+startLocation[0]+", "+startLocation[1]+")\n\n");
        
        /*=======================================================
         * 
         * Creates a path of flatten corn in the maze.
         * 
         ========================================================*/
        while (!(mazeStackRows.isEmpty() && mazeStackCols.isEmpty()))
        {
            boolean north = false, west = false, south = false, east = false; // booleans to check wich direction we goin boi
            boolean added = false; // boolean to check if a direction has been added to the maze
            
            
            
            int[] currCord = new int[2]; // array to hold the current coordinates
            currCord[0] = mazeStackRows.peek(); // current cordinate of the row
            currCord[1] = mazeStackCols.peek(); // current cordiante of the column
            
            
            north = checkNorth(currCord, maze); // returns wether the north is a possible move or not
            south = checkSouth(currCord, maze); // '' south
            west = checkWest(currCord, maze);   // '' west
            east = checkEast(currCord, maze);   // '' east
            
            
            if (north || south || west || east)
            {
                while (!added) // while a cordiante hasn't been added to the maze
                {
                    int moveThisWay = randy.nextInt(4); // holds the random movement dircetion
                    // 0 south, 1 west, 2 north, 3 east
                    
                    switch (moveThisWay)
                    {
                        case 0: 
                            if (south)
                        {
                            currCord[0] = currCord[0] + 1;
                            currCord[1] = currCord[1];
                            maze[currCord[0]][currCord[1]] = ' ';
                            mazeStackRows.push(currCord[0]);
                            mazeStackCols.push(currCord[1]);
                            added = true;
                        }
                            break;
                        case 1: 
                            if (west)
                        {
                            currCord[0] = currCord[0];
                            currCord[1] = currCord[1] - 1;
                            maze[currCord[0]][currCord[1]] = ' ';
                            mazeStackRows.push(currCord[0]);
                            mazeStackCols.push(currCord[1]);
                            added = true;
                        }
                            break;
                            
                        case 2:
                            if (north)
                        {
                            currCord[0] = currCord[0] - 1;
                            currCord[1] = currCord[1];
                            maze[currCord[0]][currCord[1]] = ' ';
                            mazeStackRows.push(currCord[0]);
                            mazeStackCols.push(currCord[1]);
                            added = true;
                        }
                            break;
                            
                        case 3:
                            if (east)
                        {
                            currCord[0] = currCord[0];
                            currCord[1] = currCord[1] + 1;
                            maze[currCord[0]][currCord[1]] = ' ';
                            mazeStackRows.push(currCord[0]);
                            mazeStackCols.push(currCord[1]);
                            added = true;
                        }
                            break;
                    } // end switch
                    
                } // end while loop ADDED
                
                added = false;
            } // end if
            else
            {
                mazeStackRows.pop();
                mazeStackCols.pop();
            } // end else
            
        } // end while loop
        entrance = 2;
        exit = 2;
        
        while (entrance % 2 == 0)
        {
            entrance = randy.nextInt( numRows - 2 ) + 1;
            
        }
        maze[entrance][0] = ' ';
        
        while (exit % 2 == 0)
        {
            exit = randy.nextInt( numRows - 2 ) + 1;
            
        }
        maze[entrance][numCols-1] = ' ';
        
        
        
        /*
         * Prints the maze as chars to the interaction's pane.
         */
        System.out.print("   ");
        for (int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.printf("\n");
        
        for (int i = 0; i < maze.length; i++){ // initially sets all characters in the array to '#'
            System.out.printf("%-3d", i);
            for (int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        } // test the printing of the maze... use me L8R BRUH
        
        
    } // end createMaze
    
    
    
    
    
    /*===================================================================================================================================
     |  Method drawMaze()
     |
     |        Purpose: Draws the maze in a canvas to be displayed to the user. 
     |              
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public void drawMaze()
    {
        StdDraw.setPenRadius(0.005);
        StdDraw.setXscale(-5, numCols);
        StdDraw.setYscale(-numRows, 5);
        StdDraw.setPenColor(StdDraw.BLACK);
        
        
        
        // pritns the text of the columns
        for (int i = 0; i < inC; i++)
        {
            String text = new String();
            text = i + text;
            StdDraw.text(i*2 + 1, 3, text);
        } // end for loop
        
        // prints the text of the rows
        for (int i = 0 ; i < inR; i++)
        {
            String text = new String();
            text = i + text;
            StdDraw.text(-1, 1 - (i*2) , text); 
        } // end for loop
        
        for (int i = 0; i < numRows; i=i+2) // draws horizontal lines you piece of shit
        {
            for (int j = 0; j < numCols - 2; j=j+2)
            {
                if (maze[i][j] == '#' && maze[i][j+1] == '#' && maze[i][j+2] == '#')
                    StdDraw.line(j, 2-i, j+2, 2-i);
            }
        }
        
        for (int j = 0; j < numCols; j=j+2)
        {
            for (int i = 0; i < numRows - 2; i=i+2)
            {
                if (maze[i][j] == '#' && maze[i+1][j] == '#' && maze[i+2][j] == '#')
                    StdDraw.line(0+j, 2 - i, 0+j, 2 - (i+2));
            }
        }
        
        
    } // end drawMaze
    
    
    
    
    
    /*===================================================================================================================================
     |  Method checkNorth
     |
     |        Purpose: Takes in the values of the current cordiante and the maze to declare wether making the move in this direction
     |                 is a legal move for this maze. Returns true/false depending on this.
     |
     |     Parameters: int[] currCord - the current cordinates being compared with
     |                 char[][] maze - the maze in a characer array format
     |
     |    Pre-Condition: Depending on the values of the parameters, will return if a move is legal.
     |   Post-Condition: Value is returned and is taken into account when selecting which way to move.
     |
     |        Returns:  true/false
     *=================================================================================================================================*/ 
    private boolean checkNorth(int[] currCord, char[][] maze)
    {
        return ( ((currCord[0] - 1) > 0) && (maze[currCord[0]-1][currCord[1]] != ' ') 
                    && (maze[ currCord[0]-2][currCord[1]] != ' ')
                    && (maze[ currCord[0]-1][currCord[1]-1] != ' ')
                    && (maze[ currCord[0]-1][currCord[1]+1] != ' '));
    } // end checkNorth
    
    
    /*===================================================================================================================================
     |  Method checkSouth
     |
     |        Purpose: Takes in the values of the current cordiante and the maze to declare wether making the move in this direction
     |                 is a legal move for this maze. Returns true/false depending on this.
     |
     |     Parameters: int[] currCord - the current cordinates being compared with
     |                 char[][] maze - the maze in a characer array format
     |
     |    Pre-Condition: Depending on the values of the parameters, will return if a move is legal.
     |   Post-Condition: Value is returned and is taken into account when selecting which way to move.
     |
     |        Returns:  true/false
     *=================================================================================================================================*/ 
    private boolean checkSouth(int[] currCord, char[][] maze)
    {
        return ((currCord[0] + 1) < (numRows-1) && (maze[currCord[0]+1][currCord[1]] != ' ') 
                    && (maze[currCord[0]+2][currCord[1]] != ' ')
                    && (maze[currCord[0]+1][currCord[1]-1] != ' ')
                    && (maze[currCord[0]+1][currCord[1]+1] != ' '));
    } // end checkNorth
    
    
    /*===================================================================================================================================
     |  Method checkWest
     |
     |        Purpose: Takes in the values of the current cordiante and the maze to declare wether making the move in this direction
     |                 is a legal move for this maze. Returns true/false depending on this.
     |
     |     Parameters: int[] currCord - the current cordinates being compared with
     |                 char[][] maze - the maze in a characer array format
     |
     |    Pre-Condition: Depending on the values of the parameters, will return if a move is legal.
     |   Post-Condition: Value is returned and is taken into account when selecting which way to move.
     |
     |        Returns:  true/false
     *=================================================================================================================================*/ 
    private boolean checkWest(int[] currCord, char[][] maze)
    {
        return ( ((currCord[1] - 1) > 0) && (maze[currCord[0]][currCord[1]-1] != ' ') 
                    && (maze[currCord[0]][currCord[1]-2] != ' ') 
                    && (maze[currCord[0]-1][currCord[1]-1] != ' ') 
                    && (maze[currCord[0]+1][currCord[1]-1] != ' '));
    } // end checkNorth
    
    
    /*===================================================================================================================================
     |  Method checkEast
     |
     |        Purpose: Takes in the values of the current cordiante and the maze to declare wether making the move in this direction
     |                 is a legal move for this maze. Returns true/false depending on this.
     |
     |     Parameters: int[] currCord - the current cordinates being compared with
     |                 char[][] maze - the maze in a characer array format
     |
     |    Pre-Condition: Depending on the values of the parameters, will return if a move is legal.
     |   Post-Condition: Value is returned and is taken into account when selecting which way to move.
     |
     |        Returns:  true/false
     *=================================================================================================================================*/ 
    private boolean checkEast(int[] currCord, char[][] maze)
    {
        return ( ((currCord[1] + 1)  < (numCols)-1) && (maze[currCord[0]][currCord[1]+1] != ' ') 
                    && (maze[currCord[0]][currCord[1]+2] != ' ')
                    && (maze[currCord[0]-1][currCord[1]+1] != ' ')
                    && (maze[currCord[0]+1][currCord[1]+1] != ' '));
    } // end checkNorth
    
    
    
} // end class