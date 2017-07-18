/*=================================================================================================================================*
 ||
 ||  Class Polynomial 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class holds an object known as a Polynomial which is simply an array of "Terms" (another class).
 ||                  This class contains several methods to hold polynomials and perform multiple actions with them.
 ||
 ||  Inherits From:  None
 ||
 ||     Interfaces:  Quantity
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  Polynomial()
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  add(Polynomial)
 ||                  addTerm(int, int)
 ||                  replicate()
 ||                  equals(Polynomial)
 ||                  evaluate(double)
 ||                  getCoefficient(int)
 ||                  isEmpty()
 ||                  isFull()
 ||                  holding()
 ||                  negate()
 ||                  scalarMultiply(int)
 ||                  toString()
 ||
 =================================================================================================================================*/
class Polynomial implements Quantity
{
    public Term [] poly; // polynomial is simply just a term array
    
    Polynomial()
    {
        poly = new Term[0];
    } // end construct
    
    
    /*===================================================================================================================================
     |  Method add
     |
     |        Purpose: Mathematically adds the polynomial 'p' to the current Polynomial, returning a new Polynomial object. Neither of
     |                 the existing Polynomial objects are changed. If both Polynomials possess terms with matching exponents, sum each
     |                 pair of matching terms.
     |
     |     Parameters: Polynomial p - the polynomial to be added to the current polynomial object.
     |
     |    Pre-Condition: Polynomial p is passed in but will not be changed and neither will the current object polynomial.
     |   Post-Condition: Polynomial object result contains the addition of two polynomials but none have been altered.
     |
     |        Returns:  result - the polynomial with the results in it
     *=================================================================================================================================*/ 
    public Polynomial add(Polynomial p)
    {   
        Polynomial result = new Polynomial();
        result.poly = this.poly;
        
        for(int i = 0; i < p.poly.length; i++)
            result.addTerm(p.poly[i].getCoeff(), p.poly[i].getExpo());
        
        return result;
    } // end add
    
    
    /*===================================================================================================================================
     |  Method addTerm
     |
     |        Purpose: Mathematically adds a term to the polynomial object with coefficent 'c' and exponent 'e'. If a term with exponent
     |                 'e' already exists, then the terms are summed and replace the old coefficent with the new sum.
     |
     |     Parameters: int c - the coefficent being passed in
     |                 int e - the exponent being passed in
     |
     |    Pre-Condition: The Polynomial object is ready to be altered for some good ol fashion fun. Int c and e are ready to party.
     |   Post-Condition: After that crazy party, this Polynomial object now has been infected with int C and int E. What a wild night.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void addTerm(int c, int e)
    {
        boolean expoExists = false;    // to check if a term with exponent 'e' already exists
        Term newTerm = new Term(c, e); // creates a new Term for the polynomial
        Term [] temp;                  // to hold the resulting Polynomial object
        
        if (poly.length == 0)          // if the polynomial is empty
        {
            temp = new Term[1]; 
            temp[0] = new Term(c, e);  // inserts the single term at index 0
            poly = temp;
            return;                    // ends the transfering
        } // end if
        else
        {
            for(int i = 0; i < poly.length; i++) // goes through polynomial to see if exponent 'e' already exists
                if (poly[i].getExpo() == e)
                {
                    poly[i].addCoeff(c); // add coefficent to current exponent location
                    return;              // no need to continue through program. end now.
                } // end if & for loop
            

            
            temp = new Term[poly.length + 1]; // creates a temp term array with one more spot to hold incoming term
            temp[poly.length] = new Term(c, e); // stores the new term at the end of the array
            
            for(int i = 0; i < poly.length; i++) // stores all the terms up until the new term into 'temp'
            {
                temp[i] = this.poly[i];
            }
            
            this.poly = temp;
            
            
            
        } // end else
        
        
        
    } // end addTerm
    
    /*===================================================================================================================================
     |  Method replicate
     |
     |        Purpose: Creates a new Polynomial object that posses a copy of the current Polynomial using a completely new collection of
     |                 objects.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: The Polynomial object is ready to copied into another Polynomial object. This should be grand.
     |   Post-Condition: Polynomial object now has an exact clone! Who can tell the difference? Not many can. Tune in next week for more.
     |
     |        Returns:  copy - exact clone of current Polynomial object
     *=================================================================================================================================*/
    public Polynomial replicate()
    {
        Polynomial copy = new Polynomial();
        copy.poly = poly;
        
        return copy;
        
    } // end replicate
    
    /*===================================================================================================================================
     |  Method equals
     |
     |        Purpose: Returns true if Polynomial being passed in has the same number of non-zero terms with the same coefficents and
     |                 same exponents as this Polynomial object. Otherwise it is false. In other words, they must be CLONES!!!!!!!!!
     |
     |     Parameters: Polynomial p - the polynomial object to be tested against this object. i hope it's ready for the test of a lifetim
     |
     |    Pre-Condition: The Polynomial object is ready to copied into another Polynomial object. This should be grand. PART 2
     |   Post-Condition: Polynomial object now has an exact clone if it was true! Otherwise false is returned
     |
     |        Returns:  true/false
     *=================================================================================================================================*/
    public boolean equals(Polynomial p)
    {
        int trueCount = 0; // holds the count of truths so far in the polynomial
        
        
        if (p.poly.length != this.poly.length)
            return false;
        
        else
        {
            for (int i = 0; i < this.poly.length; i++)
            {
                for (int j = 0; j < p.poly.length; j++)
                {
                    if (p.poly[j].getCoeff() == this.poly[i].getCoeff() && p.poly[j].getExpo() == this.poly[i].getExpo())
                        trueCount++;
                    
                } // end for loop
            } // end for loop
            
            if (trueCount == p.poly.length)
                return true;
            else
                return false;
            
        } // end of else
    }
    
    /*===================================================================================================================================
     |  Method evaluate
     |
     |        Purpose: Evaluates this Polynomial object on the value 'x' that is passed in. Returns the result of the evaluation. This is
     |                 quite the grand code my friends HAHAHAHA well then.
     |
     |     Parameters: double x - the value 'x' that the Polynomial will be evaluated at
     |
     |    Pre-Condition: The Polynomial prepares to get taken in the 'x' value to be evaluated with
     |   Post-Condition: A new double value contains the result of this all shabang.
     |
     |        Returns:  y - the result of the evaluation. GAH
     *=================================================================================================================================*/
    public double evaluate(double x)
    {
        double y = 0; // to hold the final result
        
        for(int i = 0; i < poly.length; i++)
        {
            y = y + (Math.pow( x, poly[i].getExpo() * poly[i].getCoeff()));
        } // end for loop
        
        return y;
    } // end evaluate
    
    /*===================================================================================================================================
     |  Method getCoefficient
     |
     |        Purpose: Returns the coefficient currently associated with the term with exponent e.
     |
     |     Parameters: int e - the exponent we are searching for in the list of loving coefficents with no lover
     |
     |    Pre-Condition: Polynomial object is ready to send them that exponent of beauty.
     |   Post-Condition: Nothing changed. Hopefully something was sent.
     |
     |        Returns:  coeff - the coefficent my brothers. OUR TIME IS NOW WE MUST STRIKE SEND THE CODES TO 943-765-2323
     *=================================================================================================================================*/
    public int getCoefficient(int e)
    {
        for(int i = 0; i < poly.length; i++)
            if (poly[i].getExpo() == e) // AHA!!! the location has been found
                return poly[i].getCoeff();
        
        return 0; // if no term was found, it has a '0' preceding it then
    } // end getCoefficent
    
    /*===================================================================================================================================
     |  Method isEmpty
     |
     |        Purpose: Resturns true if the Polynomial currently holds no terms, false otherwise.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: Lets not be silly now. Nothing is here.
     |   Post-Condition: You really want to be silly, dont you?
     |
     |        Returns:  true/false
     *=================================================================================================================================*/
    public boolean isEmpty()
    {
        if (poly.length == 0)
            return true;
        else
            return false;
    } // end isEmpty
    
    /*===================================================================================================================================
     |  Method isFull
     |
     |        Purpose: Resturns true if the Polynomial currently has no available space for additional terms, false otherwise.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: Lets not be silly now. Nothing is here.
     |   Post-Condition: You really want to be silly, dont you?
     |
     |        Returns:  true/false
     *=================================================================================================================================*/
    public boolean isFull()
    {
        return false; // WORK ON ME OMG I DIDNT DO THIS YET  but i did 
    }
    
    /*===================================================================================================================================
     |  Method holding
     |
     |        Purpose: Resturns the number of terms with non-zero coefficients that are currently in the Polynomial.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: Lets not be silly now. Nothing is here.
     |   Post-Condition: You really want to be silly, dont you?
     |
     |        Returns:  Number of terms
     *=================================================================================================================================*/
    public int holding()
    {
        int result = 0;
        
        for(int i = 0; i < poly.length; i++)
            if (poly[i].getCoeff() != 0)
                result++;
        
        return result;
    } // end holding
    
    
    /*===================================================================================================================================
     |  Method negate
     |
     |        Purpose: Creates a new Polynomial of new objects that has the same number of terms with the same exponents as does the
     |                 current Polynomial object, but all the signs on the coefficents are switched. Essentially a negative sign was
     |                 slapped in front of the whole thing like -(polynomial).
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: The polynomial object is ready to be negated. Don't worry though, it won't get overwritten there'll be a new one
     |   Post-Condition: The new polynomial object contains the negate version of the current polynomial object.
     |
     |        Returns:  negatedPoly - the polynomial object negated
     *=================================================================================================================================*/
    public Polynomial negate()
    {
        Polynomial negatedPoly = new Polynomial(); // to hold the negated version of the polynomial
        negatedPoly.poly = poly;
        
        for(int i = 0; i < poly.length; i++)
            negatedPoly.poly[i].multiplyCoeff(-1); // multiply by -1 to all values
        
        return negatedPoly;
    } // end negate
    
    /*===================================================================================================================================
     |  Method scalarMultiply
     |
     |        Purpose: Multiplies each term's coefficent with the value that is passed in... s. THE CULPRIT IS HERE, SEND HER DWNSTRS
     |
     |     Parameters: int s - the term to multiply each coefficent by
     |
     |    Pre-Condition: The polynomial object is ready to get multipled by the term s.
     |   Post-Condition: The polynomial object now contains new coefficents that were multiplied by the term s.
     |
     |        Returns:  (none)
     *=================================================================================================================================*/
    public void scalarMultiply(int s)
    {
        for(int i = 0; i < poly.length; i++)
            poly[i].multiplyCoeff(s);
        
    } // end scalarMultiply
    
    /*===================================================================================================================================
     |  Method toString
     |
     |        Purpose: Creates a String representation of the current Polynomial object. The terms are laid out in decreasing order by
     |                 exponent. All coefficients and exponents are displayed and paranthesized and one space is given on either side
     |                 of the addition and subtractions.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: Polynomial prepares to get transformed into a string. IS IT READY I DONT KNOW EAT MY CHICKEN
     |   Post-Condition: What is ultimately returned is the Polynomial object in string form.
     |
     |        Returns:  string of polynomial object
     *=================================================================================================================================*/
    public String toString()
    {
        String result = new String("");      // to hold the final string result
        int [] temp = new int[poly.length];  // int array to hold the exponents in decending order
        int x = 0;                           // temp value to hold an exponent while it is rearranged
        
        
        for (int i = 0; i < poly.length; i++) // puts all exponents in integer array to compare easily and rearrange
            temp[i] = poly[i].getExpo();
        
        
        
        /////An Array sort algorithm using two for loops////////////////////////////////////////////
        for(int i = 0; i < poly.length; i++)
        {
            for (int j = i + 1; j < poly.length; j++)
            {
                if (temp[i] > temp[j])
                {
                    x = temp[i];
                    temp[i] = temp[j];
                    temp[j] = x;
                } // end if
            } // end for loop
        } // end for loop
        ////End of the Array sort algorithm... dont you just love it when you did this in ECE 175////
        
        
        
        
        for (int i = 0; i < temp.length; i++) // outter loop holding the exponent to be compared to
        {
            for (int j = 0; j < poly.length; j++) // inner loop holding the polynomail exponents that are compared to the outter one
            {
                if (poly[j].getExpo() == temp[i])
                {
                    if (poly[j].getCoeff() > 0) // if positive a '+' is placed
                        result = " + " + poly[j].toString() + result;
                        
                    else // otherwise it is a ' - '
                        result = " - " + poly[j].toString() + result;
                } // end if
            } // end inner for
        } // end outter for
        
        if (result.charAt(1) == '+')
            result = result.substring(3, result.length()); // this substring removes the preceding signs
        
        return result;
    } // end toString

    
    
} // end Polynomial