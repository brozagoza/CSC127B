import java.awt.Point;
/*=================================================================================================================================*
 ||
 ||  Interface CS127BQueueInterface
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This is the interface for the CS127BQueue class that must include the following methods in order to work
 ||                  properly.
 ||
 ||
 ||
 =================================================================================================================================*/
public interface CS127BQueueInterface
{
    public boolean enqueue(Point a); // adds to the queue
    
    public Point dequeue(); // removes from the queue
    
    public boolean isEmpty(); // returns true if empty
    
    public int getSize(); // capacity of teh queue
    
    public int getOccupancy(); // size of the queue
} // end interface
