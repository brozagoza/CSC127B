import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Deck
{
  int size;  // the size of the deck
  Node head; // to hold the head of the list
  Node tail; // hold the tail of the list
  
  
  /*===================================================================================================================================
   |  Constructor Deck(string)
   |
   |        Purpose: Creates a deck object and populates it with the cards found from the given file passed in as a String in the
   |                 order the cards appear in.
   |
   |     Parameters: String filename - the name of the file the figure will be read from
   |
   |    Pre-Condition: file is passed in and will be stored as a Deck object
   |   Post-Condition: Deck object now contains all the legal cards from the file
   |
   |        Returns:  (void)
   *=================================================================================================================================*/
  Deck (String filename)
  {
    BufferedReader theFile = null; // to hold the file read in
    String line = "";              // to temporarily hold the given line of the file
    String rankStr = "";           // to hold the rank as a string temporarily
    int rankInt = 0;               // holds the rank as an int
    Card tempCard = null;          // holds the card at the given location in the file
    Node lastNode = null;          // to hold the final node in case of deletion
    
    
    head = new Node(null);
    tail = new Node(null);
    size = 0;
    
    try
    {
      theFile = new BufferedReader(new FileReader(filename)); // reads in the file
      
      while ((line = theFile.readLine()) != null) // until the end of the file
      {
        line = line.trim(); // removes trailing and leading whitespace
        
        rankStr = line.substring(0, line.indexOf(' '));
        rankInt = Integer.parseInt(rankStr); // puts the rank as an int
        
        line = line.substring(rankStr.length(), line.length());
        line = line.trim();
        line = line.toUpperCase(); // line holds the suit as all caps with no spaces
        
        
        if ( rankInt > 0 && rankInt < 14)
          if (line.equals("CLUBS") || line.equals("HEARTS") || line.equals("DIAMONDS") || line.equals("SPADES"))
        {
          tempCard = new Card(rankInt, line); // creats a new object that is to be added to teh list
          Node tempNode = new Node(tempCard); // creates a new node of that new object
          insertAfter(tail, tempNode);        // inserts it after the tail of the list
          
          lastNode = tempNode;                // last node so far
         
        } // end if
        
        if (size == 104) // no more than 104 cards please!
          break;
        
      } // end while
      
    } // end try
    catch (FileNotFoundException e)
    {
      System.out.print("File "+filename+" was not found, please try again.");
    } // end catch
    catch (IOException e)
    {
    }
    
    System.out.println(lastNode.getData().toString());
    
    
    if (size%2 != 0) // if odd number of cards delete the last one
      delete(lastNode);
      
    
    
  } // end constructor
  
  /*===================================================================================================================================
   |  Constructor Deck(stringbuilder)
   |
   |        Purpose: Creates a deck object and populates it with the cards found from the given file passed in as a StringBuilder
   |                 using the ordering scheme Clubs, Diamonds, Hearts, and Spades.
   |
   |     Parameters: StringBuilder filename - the name of the file the figure will be read from
   |
   |    Pre-Condition: file is passed in and will be stored as a Deck object
   |   Post-Condition: Deck object now contains all the legal cards from the file
   |
   |        Returns:  (void)
   *=================================================================================================================================*/
  Deck(StringBuilder filename)
  {
    BufferedReader theFile = null; // to hold the file read in
    String line = "";              // to temporarily hold the given line of the file
    String rankStr = "";           // to hold the rank as a string temporarily
    int rankInt = 0;               // holds the rank as an int
    Card tempCard = null;          // holds the card at the given location in the file
    Node lastNode = null;
    head = new Node(null);
    tail = new Node(null);
    size = 0;
    
    try
    {
      theFile = new BufferedReader(new FileReader(filename.toString())); // reads in the file
      
      while ((line = theFile.readLine()) != null) // until the end of the file
      {
        line = line.trim(); // removes trailing and leading whitespace
        
        rankStr = line.substring(0, line.indexOf(' '));
        rankInt = Integer.parseInt(rankStr); // puts the rank as an int
        
        line = line.substring(rankStr.length(), line.length());
        line = line.trim();
        line = line.toUpperCase(); // line holds the suit as all caps with no spaces
        
        
        if ( rankInt > 0 && rankInt < 14)
          if (line.equals("CLUBS") || line.equals("HEARTS") || line.equals("DIAMONDS") || line.equals("SPADES"))
        {
          tempCard = new Card(rankInt, line); // creats a new object that is to be added to teh list
          Node tempNode = new Node(tempCard); // creates a new node of that new object
          lastNode = tempNode;
          
          
          if (head.getData() == null) // if the list is empty simply append it to the front
            insertAfter(tail, tempNode);
          else
          {
            Node nodeBefore = head;
            Node nodeAfter = head.getNext();
            boolean first = false; // used to check the first card since the card before is null so no out of bounds yay
            
            
            while (nodeBefore != null)
            {
              System.out.println("While loop working with: "+ tempNode.getData().getSuit()+" "+tempNode.getData().getRank());
              System.out.println("NodeBefore is: "+nodeBefore.getData().getSuit()+" "+nodeBefore.getData().getRank());
              if (nodeAfter != null) System.out.println("NodeAfter is: "+nodeAfter.getData().getSuit()+" "+nodeAfter.getData().getRank());
              
              if(!first) // checks if the new card is "less" than the head of the list
              {
                if (tempNode.getData().getSuit().charAt(0) < nodeBefore.getData().getSuit().charAt(0))
                {
                  newHead(tempNode);
                  break;
                } // end if
                else if (tempNode.getData().getSuit().charAt(0) == nodeBefore.getData().getSuit().charAt(0))
                {
                  if (tempNode.getData().getRank() < nodeBefore.getData().getRank())
                    newHead(tempNode);
                  else
                    nodeBefore = null;
                  break;
                } // end else if
                first = true; // only checks once per new card
              } // if first statement
              if (nodeAfter != null)
              {
                if (tempNode.getData().getSuit().charAt(0) < nodeAfter.getData().getSuit().charAt(0))
                {
                  System.out.println(tempNode.getData().getSuit().charAt(0));
                  System.out.println(nodeAfter.getData().getSuit().charAt(0));
                  insertAfter(nodeBefore, tempNode);
                  break;
                } // end if
                else if (tempNode.getData().getSuit().charAt(0) == nodeAfter.getData().getSuit().charAt(0))
                {
                  if (tempNode.getData().getRank() < nodeAfter.getData().getRank())
                  {
                    insertAfter(nodeBefore, tempNode);
                    break;
                  }
                } // end else if
              } // end else
              
              
              
              
              
              
              
              
              nodeBefore = nodeBefore.getNext();
              if (nodeAfter == null)
                break;
              nodeAfter = nodeAfter.getNext();
            } // end while
            
            if (nodeBefore == null)
            {
              insertAfter(tail, tempNode);
              //newHead(tempNode);
            } // end if
            
          }
          
        } // end if
        
        if (size == 104) // no more than 104 cards please!
          break;
      } // end while
      
    } // end try
    catch (FileNotFoundException e)
    {
      System.out.print("File "+filename+" was not found, please try again.");
    } // end catch
    catch (IOException e)
    {
      System.out.print("IOException!");
    }

    
    if (size%2 != 0) // if odd number of cards delete the last one
      delete(lastNode);
    
    
  } // end constructor 2
  
  
  // inserts after the current node passed in
  private void insertAfter(Node currNode, Node newNode)
  {
    Node temp = null;
    
    if (size == 0)
    {
      head = newNode;
      tail = head;
      size++;
    } // end if
    else if (currNode == tail)
    {
      tail.setNext(newNode);
      tail = newNode;
      size++;
    }
    else
    {
      temp = currNode.getNext();
      newNode.setNext(temp);
      currNode.setNext(newNode);
      size++;
    }
    
    return;
  } // end insertAfter
  
  
  private void newHead(Node currNode)
  {
    Node temp = head;
    
    currNode.setNext(temp);
    head = currNode;
    size++;
    
    return;
  } // end newHead
  
  
  private void delete(Node currNode)
  {
    Node before = head;
    Node after = head.getNext();
    
    System.out.println(size);
    System.out.println(currNode.getData().toString());
    
    if (currNode == head)
    {
      head = currNode.getNext();
    }
    else{
      
      while(before != null)
      {
        if (before.getNext() == currNode)
        {
            System.out.println("Before is "+before.getData().toString());
            System.out.println("After is "+after.getData().toString());
            before.setNext(after.getNext());
            --size;
      
          System.out.println(size);
          System.out.println(this.toString());
          return;
        }
        
        before = before.getNext();
        if (after.getNext() != null)
          after = after.getNext();
      } // end while
    
    } // end else
    
  }
  
  
  
  
  
  
  
  
  
  
  public void outShuffle()
  {
  } // end outShuffle
  
  public void inShuffle()
  {
  } // end inShuffle
  
  public String toString()
  {
    String str = "";
    Node temp = head;
    
    for(int i = 0; i < size; i++)
    {
      str = str + temp.getData().toString();
      temp = temp.getNext();
      str = str + " ";
    }
    
    return str;
  } // end toString
  
} // end Deck