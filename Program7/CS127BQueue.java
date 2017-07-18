/*=================================================================================================================================*
 ||
 ||  Class CS127BQueue 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class represents the idea of a "queue" in Java, which is basically
 ||                  a line of arguments (for us western speakers). This queue follows the idea
 ||                  of a circular array meaning there is no "end" as the data simply wraps around.
 ||
 ||  Inherits From:  None
 ||
 ||     Interfaces:  CS127BQueueInterface
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  CS127BQueue(int size)
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  enqueue(Point)
 ||                  dequeue(Point)
 ||
 =================================================================================================================================*/
import java.awt.Point; // Point object imported b.c. is needed dawg

class CS127BQueue implements CS127BQueueInterface
{
    private Point[] theQueue; // the queue. what more can i say
    private int size;         // holds the total size of the queue
    private int front;        // front of the queue
    private int rear;         // rear
    private int occupancy;    // total number of data in the queue (not the same as size)
    
    /*===================================================================================================================================
     |  Constructor CS127BQueue
     |
     |        Purpose: Declares a new queue that is an array of Point objects.
     |
     |     Parameters: int size - the size of the queue
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Creates a new queue.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public CS127BQueue(int size)
    {
        this.size = size;
        theQueue = new Point[size];
        front = 0;
        rear = -1;
        occupancy = 0;
    } // end constructor
    
    /*===================================================================================================================================
     |  Method enqueue
     |
     |        Purpose: Adds a new Point object to the end of the queue. If the queue is already full, it doesn't get added.
     |
     |     Parameters: Point a - the Point object that is to be added to the queue
     |
     |    Pre-Condition: rear holds the location of where the new Point object is going to go
     |   Post-Condition: theQueue now has a new Point object where rear was before
     |
     |        Returns:  true/false (false if it's full)
     *=================================================================================================================================*/
    public boolean enqueue(Point a)
    {
        if (occupancy == size)
        {
            System.out.println("No space in queue.");
            return false;
        }
        
        theQueue[rear+1] = a;
        rear++;
        occupancy++;
        return true;
        
        
    } // end enqueue
    
    
    /*===================================================================================================================================
     |  Method dequeue
     |
     |        Purpose: Deletes the Point object at the 'front' of the queue. If it is already empty, nothing happens and returns false.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: front holds the location of the object to be erased
     |   Post-Condition: theQueue now has one less Point object where front was before
     |
     |        Returns:  true/false (false if it's empty)
     *=================================================================================================================================*/
    public Point dequeue()
    {
        if (occupancy == 0)
        {
            System.out.println("The queue is already empty my friends.");
        } // end if
        
        Point dequeuedPoint = theQueue[front];
        theQueue[front] = null;
        front++;
        occupancy--;
        return dequeuedPoint;
    } // end dequeue
    
    /*===================================================================================================================================
     |  Method printQueue
     |
     |        Purpose: Prints the que for debugging purposes.
     |
     *=================================================================================================================================*/
    public void printQueue()
    {
        if (occupancy == 0)
        {
            System.out.println("The queue is empty so nothing will get printed anyway");
            return;
        } // end if
        
        for (int i = front; i <= rear; i++)
            System.out.print("("+(int)theQueue[i].getX()+", "+(int)theQueue[i].getY()+") ");
    } // end print Queue
    
    

    /*===================================================================================================================================
     |  Method isEmpty
     |
     |        Purpose: If the queue is empty will return true otherwise false.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  true/false (true if it's empty)
     *=================================================================================================================================*/
    public boolean isEmpty()
    {
        return occupancy == 0;
    }
    
    /*===================================================================================================================================
     |  Method getSize()
     |
     |        Purpose: Returns the total size of the queue.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  size
     *=================================================================================================================================*/
    public int getSize()
    {
        return size;
    } // end getSize
    
    /*===================================================================================================================================
     |  Method getOccupancy
     |
     |        Purpose: Returns the number of Points in this queue object. Not the total size of this queue
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  occuancy
     *=================================================================================================================================*/
    public int getOccupancy()
    {
        return occupancy;
    } // end get Occupancy
    
    
} // end class