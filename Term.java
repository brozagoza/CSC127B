/*=================================================================================================================================*
 ||
 ||  Class Term 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class holds an object known as a "term" and performs multiple actions with this term.
 ||                  This class was primarily made for the Polynomial class.
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
    public int coeff; // the coefficent my brothers
    public int expo; // the exponent my brothers

    //the constructor with two arguemnts for coefficent and exponent
    public Term(int coeffIn, int expoIn)
    {
        coeff = coeffIn;
        expo = expoIn;
    } // end constructor
    
    // the constructor with just the coefficent and no exponent
    public Term(int coeffIn)
    {
        coeff = coeffIn;
        expo = 0;
    }
    
    
    public int getCoeff()
    {
        return coeff;
    }
    
    public int getExpo()
    {
        return expo;
    }
    
    public void addCoeff(int c)
    {
        coeff = coeff + c;
    }
    
    public void multiplyCoeff(int c)
    {
        coeff = coeff * c;
    }
    
    public void addExpo(int e)
    {
        expo = expo + e;
    }
    
    public void multiplyExpo(int e)
    {
        expo = expo * e;
    }
    
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