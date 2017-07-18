import java.io.*;
import java.util.*;
/*=================================================================================================================================*
 ||
 ||  Class Stack 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class is my very own stack class using the stack methods peek, pop, push, and penitrate.
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
 ||   Constructors:  Stack()
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  push(int)
 ||                  pop()
 ||                  peek()
 ||                  isEmpty()
 ||
 =================================================================================================================================*/
class Stack
{
    private LinkedList<Integer> theStack;
    
    
    /*===================================================================================================================================
     |  Constructor Stack
     |
     |        Purpose: Declares a new stack item using char array as the data collection. No size.
     |              
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Object created!
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public Stack()
    {
        theStack = new LinkedList<Integer>();
    } // end constructor
    
    
    /*===================================================================================================================================
     |  Method push
     |
     |        Purpose: Adds the item to the end of the list... or should I say, stack? Hmmmm-hmmm-hmmm.
     |              
     |
     |     Parameters: int pushee - item to be added to the list
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Stack now contains new integer item.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public void push(Integer pushee)
    {
        theStack.add(pushee);
    } // end push
    
    /*===================================================================================================================================
     |  Method pop
     |
     |        Purpose: Deletes the item at the top of the stack... or should I say, linked list? Hmmmm-hmmmm-hmmmm.
     |              
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Stack now contains one less item.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public void pop()
    {
        theStack.removeLast(); //(theStack.size()-1); // the last item is set in valueLost for debugging purposes
    } // end pop
    
    /*===================================================================================================================================
     |  Method peek
     |
     |        Purpose: Returns the item contained at the top of the stack... or should I say, stack? welp.
     |              
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  Int item at the top of the list
     *=================================================================================================================================*/ 
     public Integer peek()
     {
         
         return theStack.get( theStack.size() - 1);
     } // end peek
     
     /*===================================================================================================================================
     |  Method isEmpty
     |
     |        Purpose: If this stack is empty return true, otherwise return false.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Stack now contains one less item.
     |
     |        Returns:  boolean
     *=================================================================================================================================*/ 
      public boolean isEmpty()
      {
          return theStack.size() == 0;
      } // end isEmpty
    
} // end Stack