/*=================================================================================================================================*
 ||
 ||  Class Node 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class represents a card object that contains a suit and a rank
 ||                  from that suit
 ||
 ||  Inherits From:  Comparable<Card>
 ||
 ||     Interfaces:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  Node(Card inCard)
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  getData()
 ||                  getNext()
 ||                  setData()
 ||                  setNext()
 ||
 =================================================================================================================================*/
class Node
{
    Card card; // reference to this card
    Node next; // reference to the next node
    
    /*===================================================================================================================================
   |  Constructor Node(Card inCard)
   |
   |        Purpose: Creates a node object with the card object that is passed in.
   |
   |     Parameters: Card inCard - the card being passed in
   |
   |    Pre-Condition: Card passed in
   |   Post-Condition: Node created
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
    Node(Card inCard)
    {
        card = inCard;
        next = null;
    } // end constructor
    
    /*===================================================================================================================================
   |  Method getData()
   |
   |        Purpose: Returns the data of this Node object.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  Card card
   *=================================================================================================================================*/
    public Card getData()
    {
        return card;
    } // end getData
    
    /*===================================================================================================================================
   |  Method getnext()
   |
   |        Purpose: Returns the next node object this node object references.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  Node next
   *=================================================================================================================================*/
    public Node getNext()
    {
        return next;
    } // end getNext
    
    /*===================================================================================================================================
   |  Method setData()
   |
   |        Purpose: Overrides this node's object card with a new card object that is passed in.
   |
   |     Parameters: Card inCard - the card to became the new data
   |
   |    Pre-Condition: will contain the old data
   |   Post-Condition: now contains the card passed in
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
    public void setData(Card inCard)
    {
        card = inCard;
    } // end setData
    
    /*===================================================================================================================================
   |  Method setNext()
   |
   |        Purpose: Sets the reference of this node object to a new node object (one being passed in).
   |
   |     Parameters: Node next - the node object this node will reference
   |
   |    Pre-Condition: will point to what it pointed to before
   |   Post-Condition: will now point to the new object that was passed in
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
    public void setNext(Node next)
    {
        this.next = next;
    } // end setNext
} // end Node