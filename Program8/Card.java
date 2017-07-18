/*=================================================================================================================================*
 ||
 ||  Class Card 
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
 ||   Constructors:  Card(int r, String s)
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  getrank()
 ||                  getSuit()
 ||                  toString()
 ||                  compareTo(Card in)
 ||
 =================================================================================================================================*/
public class Card implements Comparable<Card>
{
    int rank; // holds the rank of the card as an integer
    String suit; // holds the suit of the card as a string
    
    
    /*===================================================================================================================================
     |  Constructor Card(int, string)
     |
     |        Purpose: Creates a card object when given a rank(int) and a suit(string).
     |
     |     Parameters: int r - the rank of the card
     |                 String s - the suit of the card
     |
     |    Pre-Condition: two parameters are passed in
     |   Post-Condition: Card object created
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    Card(int r, String s)
    {
        rank = r;
        suit = s;
    } // end constructor
    
    
    /*===================================================================================================================================
   |  Method getRank()
   |
   |        Purpose: Returns the rank of the card as an int.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  rank
   *=================================================================================================================================*/
    public int getRank()
    {
        return rank;
    } // end getRank
    
    /*===================================================================================================================================
   |  Method getSuit()
   |
   |        Purpose: Returns the suit of the card as an int.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  suit
   *=================================================================================================================================*/
    public String getSuit()
    {
        return suit;
    } // end getSuit
    
    
    /*===================================================================================================================================
   |  Method toString()
   |
   |        Purpose: Returns the rank and suit of the card as an string in 2/3 char form: J2. 
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  string returnMe
   *=================================================================================================================================*/
    public String toString()
    {
        String returnMe = ""; // the string being returned
        
        switch (rank)
        {
            case 1:
                returnMe = returnMe + "A";
                break;
                
            case 11:
                returnMe = returnMe + "J";
                break;
                
            case 12:
                returnMe = returnMe + "Q";
                break;
                
            case 13:
                returnMe = returnMe + "K";
                break;
                
            default:
                returnMe = returnMe + rank; // since rank is a number it simply adds that number to the string
                break;
        } // end the switch
        
        returnMe = returnMe + suit.charAt(0);
        
        return returnMe;
    } // end toString
    
    /*===================================================================================================================================
   |  Method compareTo()
   |
   |        Purpose: Method implemented from the Comparable class. Honestly just here because the McCann wanted it.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  int
   *=================================================================================================================================*/
    public int compareTo(Card in)
    {
        return 1;
    } // end compareTo
} // end Card