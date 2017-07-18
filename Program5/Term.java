/*=================================================================================================================================*
 ||
 ||  Class Term 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class holds an object known as a "term" and performs multiple actions with this term.
 ||                  This class was primarily made for the PolynomialA and PolynomialB classes.
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
 ||   Constructors:  BinaryNumber()
 ||                  BinaryNumber(String str)
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  setValue(String)
 ||                  toString()
 ||                  equal(BinaryNumber)
 ||                  incrementBy(BinaryNumber)
 ||                  decrementBy(BinaryNumber)
 ||
 =================================================================================================================================*/
class Term {
  private int coeff; // the coefficent my brothers
  private int expo; // the exponent my brothers
  
  /*===================================================================================================================================
   |  Constructor Term
   |
   |        Purpose: Creates a new Term object that posses a coefficient and an exponent. The coefficient and exponent are passed in
   |                 in this case.
   |
   |     Parameters: int coeffIn
   |                 int expoIn
   |
   |    Pre-Condition: Term object will be made IN THE FUTURE WHAT BEWARE ITS COMING OMG I HAVE A PHYSICS TEST AND IM DOING THIS BOO
   |   Post-Condition: Term object will be made
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
  public Term(int coeffIn, int expoIn)
  {
    coeff = coeffIn;
    expo = expoIn;
  } // end constructor
  
  /*===================================================================================================================================
   |  Constructor Term
   |
   |        Purpose: Creates a new Term object that posses a coefficient and an exponent. The coefficient is passed in
   |                 in this case.
   |
   |     Parameters: int coeffIn
   |
   |    Pre-Condition: Term object will be made IN THE FUTURE WHAT BEWARE ITS COMING OMG I HAVE A PHYSICS TEST AND IM DOING THIS BOO
   |   Post-Condition: Term object will be made
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
  public Term(int coeffIn)
  {
    coeff = coeffIn;
    expo = 0;
  } // end constructor
  
  /*===================================================================================================================================
   |  Method getCoeff
   |
   |        Purpose: Returns coefficient
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  coefficient
   *=================================================================================================================================*/
  public int getCoeff()
  {
    return coeff;
  }
  
  /*===================================================================================================================================
   |  Method getExpo
   |
   |        Purpose: Returns exponent
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  exponent
   *=================================================================================================================================*/
  public int getExpo()
  {
    return expo;
  }
  
  /*===================================================================================================================================
   |  Method addCoeff
   |
   |        Purpose: Returns coefficient with addition done.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
  public void addCoeff(int c)
  {
    coeff = coeff + c;
  }
  
  /*===================================================================================================================================
   |  Method multiplyCoeff
   |
   |        Purpose: Returns coefficient multiplied by value
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
  public void multiplyCoeff(int c)
  {
    coeff = coeff * c;
  }
  
  /*===================================================================================================================================
   |  Method addExpo
   |
   |        Purpose: Returns exponent with addition done.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
  public void addExpo(int e)
  {
    expo = expo + e;
  }
  
  /*===================================================================================================================================
   |  Method multiplyExpo
   |
   |        Purpose: Returns exponent with multiplication done.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  (none)
   *=================================================================================================================================*/
  public void multiplyExpo(int e)
  {
    expo = expo * e;
  }
  
  /*===================================================================================================================================
   |  Method toString
   |
   |        Purpose: Returns the term as a string.
   |
   |     Parameters: (none)
   |
   |    Pre-Condition: (none)
   |   Post-Condition: (none)
   |
   |        Returns:  result(string)
   *=================================================================================================================================*/
  public String toString()
  {
    String result = new String(); // to hold the resulting string
    
    if (coeff > 0)
      result = "(" + coeff + ")x^(" + expo + ")";
    else
      result = "(" + (-1 * coeff) + ")x^(" + expo + ")";
    
    return result;
  }
  
} // end Term