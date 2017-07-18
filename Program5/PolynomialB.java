import java.util.*; // imports array list to be used in this program my brothers let us begin the fight LETS US MARCH INTO WAR
/*=================================================================================================================================*
 ||
 ||  Class PolynomialB
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class holds an object known as a PolynomialB which is simply a LinkedList of "Terms" (another object).
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
 ||   Constructors:  PolynomialB()
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  add(PolynomialB)
 ||                  addTerm(int, int)
 ||                  replicate()
 ||                  equals(PolynomialB)
 ||                  evaluate(double)
 ||                  getCoefficient(int)
 ||                  isEmpty()
 ||                  isFull()
 ||                  holding()
 ||                  negate()
 ||                  scalarMultiply(int)
 ||                  toString()
 ||                  exponentList()
 ||
 =================================================================================================================================*/
class PolynomialB implements Quantity
{
    private LinkedList<Term> poly; // the polynomial BROTHERS
    
    /*===================================================================================================================================
     |  Constructor PolynomialBB
     |
     |        Purpose: Initializes a new polynomialB object as a LinkedList
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Object is created.
     |
     *=================================================================================================================================*/ 
    PolynomialB()
    {
        poly = new LinkedList<Term>();
    }
    
    
    /*===================================================================================================================================
     |  Method add
     |
     |        Purpose: Mathematically adds the polynomial 'p' to the current PolynomialB, returning a new PolynomialB object. Neither of
     |                 the existing PolynomialB objects are changed. If both PolynomialBs possess terms with matching exponents, sum each
     |                 pair of matching terms.
     |
     |     Parameters: PolynomialB p - the polynomial to be added to the current polynomial object.
     |
     |    Pre-Condition: PolynomialB p is passed in but will not be changed and neither will the current object polynomial.
     |   Post-Condition: PolynomialB object result contains the addition of two polynomials but none have been altered.
     |
     |        Returns:  result - the polynomial with the results in it
     *=================================================================================================================================*/ 
    public PolynomialB add(PolynomialB p)
    {   
        PolynomialB result = new PolynomialB();
        
        for (int i = 0; i < poly.size(); i++) // sets all the objects from this polynomial into the resulting one
            result.addTerm(poly.get(i).getCoeff(), poly.get(i).getExpo());
        
        List<Integer> resultExpos;
        resultExpos = p.exponentList(); // contains the list of exponents
        
        for (int i = 0; i < resultExpos.size(); i++) // adds all the new terms from the new polynomial
            result.addTerm(p.getCoefficient(resultExpos.get(i)), resultExpos.get(i) );
        
        
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
     |    Pre-Condition: The PolynomialB object is ready to be altered for some good ol fashion fun. Int c and e are ready to party.
     |   Post-Condition: After that crazy party, this PolynomialB object now has been infected with int C and int E. What a wild night.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void addTerm(int c, int e)
    {
        boolean expoExists = false;    // to check if a term with exponent 'e' already exists
        Term newTerm = new Term(c, e); // creates a new Term for the polynomial
        Term tempTerm;
        LinkedList<Term> polyTemp = new LinkedList<Term>();                  // to hold the resulting PolynomialB object
        
        if (poly.isEmpty())          // if the polynomial is empty
        {
            polyTemp.add(newTerm);
            poly = polyTemp;
            return;                    // ends the transfering
        } // end if
        else
        {
            for (int i = 0; i < poly.size(); i++)
            {
                tempTerm = poly.get(i); // gets the term at this location temporarilly
                if (tempTerm.getExpo() == e)
                {
                    tempTerm = new Term( tempTerm.getCoeff() + c, e);
                    poly.set(i, tempTerm);
                    expoExists = true;
                } // end if
            } // end for loop
            
            if (!expoExists)
            {
                poly.add(newTerm); // simply adds the new term to the end of the list my brothers
            } // end if
            
        } // end else
        
    } // end addTerm
    
    
    /*===================================================================================================================================
     |  Method replicate
     |
     |        Purpose: Creates a new PolynomialB object that posses a copy of the current PolynomialB using a completely new collection of
     |                 objects.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: The PolynomialB object is ready to copied into another PolynomialB object. This should be grand.
     |   Post-Condition: PolynomialB object now has an exact clone! Who can tell the difference? Not many can. Tune in next week for more.
     |
     |        Returns:  copy - exact clone of current PolynomialB object
     *=================================================================================================================================*/
    public PolynomialB replicate()
    {
        PolynomialB copy = new PolynomialB();
        copy.poly = poly;
        
        return copy;
        
    } // end replicate
    
    
    
    /*===================================================================================================================================
     |  Method equals
     |
     |        Purpose: Returns true if PolynomialB being passed in has the same number of non-zero terms with the same coefficents and
     |                 same exponents as this PolynomialB object. Otherwise it is false. In other words, they must be CLONES!!!!!!!!!
     |
     |     Parameters: PolynomialB p - the polynomial object to be tested against this object. i hope it's ready for the test of a lifetim
     |
     |    Pre-Condition: The PolynomialB object is ready to copied into another PolynomialB object. This should be grand. PART 2
     |   Post-Condition: PolynomialB object now has an exact clone if it was true! Otherwise false is returned
     |
     |        Returns:  true/false
     *=================================================================================================================================*/
    public boolean equals(PolynomialBB p)
    {
        int trueCount = 0; // holds the count of truths so far in the polynomial
        
        List<Integer> resultExpos;
        resultExpos = p.exponentList();
        
        if (resultExpos.size() != poly.size())
            return false;
        
        else
        {
            for (int i = 0; i < poly.size(); i++)
            {
                for (int j = 0; j < resultExpos.size(); j++)
                {
                    if //(
                        //p.poly.get(j).getCoeff() == this.poly.get(i).getCoeff() && 
                        //p.poly.get(j).getExpo() == this.poly.get(i).getExpo()
                        //)
                        (
                         p.getCoefficient(resultExpos.get(j)) == poly.get(i).getCoeff() &&
                         resultExpos.get(j) == poly.get(i).getExpo()
                        )
                        ++trueCount;
                    
                } // end for loop
            } // end for loop
            
            if (trueCount == poly.size())
                return true;
            else
                return false;
            
        } // end of else
    } // end equals my brothers UNTIL WE FIGHT ANOTHER DAY
    
    /*===================================================================================================================================
     |  Method evaluate
     |
     |        Purpose: Evaluates this PolynomialB object on the value 'x' that is passed in. Returns the result of the evaluation. This is
     |                 quite the grand code my friends HAHAHAHA well then.
     |
     |     Parameters: double x - the value 'x' that the PolynomialB will be evaluated at
     |
     |    Pre-Condition: The PolynomialB prepares to get taken in the 'x' value to be evaluated with
     |   Post-Condition: A new double value contains the result of this all shabang.
     |
     |        Returns:  y - the result of the evaluation. GAH
     *=================================================================================================================================*/
    public double evaluate(double x)
    {
        double y = 0; // to hold the final result
        
        for(int i = 0; i < poly.size(); i++)
        {
            y = y + (poly.get(i).getCoeff() * Math.pow(x, poly.get(i).getExpo()));//   (5)x^2
        }
        
        return y;
    } // end evaluate
    
    
    /*===================================================================================================================================
     |  Method getCoefficient
     |
     |        Purpose: Returns the coefficient currently associated with the term with exponent e.
     |
     |     Parameters: int e - the exponent we are searching for in the list of loving coefficents with no lover
     |
     |    Pre-Condition: PolynomialB object is ready to send them that exponent of beauty.
     |   Post-Condition: Nothing changed. Hopefully something was sent.
     |
     |        Returns:  coeff - the coefficent my brothers. OUR TIME IS NOW WE MUST STRIKE SEND THE CODES TO 943-765-2323
     *=================================================================================================================================*/
    public int getCoefficient(int e)
    {
        for(int i = 0; i < poly.size(); i++)
            if (poly.get(i).getExpo() == e) // AHA!!! the location has been found
            return poly.get(i).getCoeff();
        
        return 0; // if no term was found, it has a '0' preceding it then
    } // end getCoefficent
    
    
    /*===================================================================================================================================
     |  Method isEmpty
     |
     |        Purpose: Resturns true if the PolynomialB currently holds no terms, false otherwise.
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
        if (poly.isEmpty())
            return true;
        else
            return false;
    } // end isEmpty
    
    /*===================================================================================================================================
     |  Method isFull
     |
     |        Purpose: Resturns true if the PolynomialB currently has no available space for additional terms, false otherwise.
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
     |        Purpose: Resturns the number of terms with non-zero coefficients that are currently in the PolynomialB.
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
        
        for(int i = 0; i < poly.size(); i++)
            if (poly.get(i).getCoeff() != 0)
            result++;
        
        return result;
    } // end holding
    
    /*===================================================================================================================================
     |  Method negate
     |
     |        Purpose: Creates a new PolynomialB of new objects that has the same number of terms with the same exponents as does the
     |                 current PolynomialB object, but all the signs on the coefficents are switched. Essentially a negative sign was
     |                 slapped in front of the whole thing like -(polynomial).
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: The polynomial object is ready to be negated. Don't worry though, it won't get overwritten there'll be a new one
     |   Post-Condition: The new polynomial object contains the negate version of the current polynomial object.
     |
     |        Returns:  negatedPoly - the polynomial object negated
     *=================================================================================================================================*/
    public PolynomialB negate()
    {
        PolynomialB negatedPoly = new PolynomialB(); // to hold the negated version of the polynomial
        negatedPoly.poly = poly;
        
        for(int i = 0; i < poly.size(); i++)
            negatedPoly.poly.get(i).multiplyCoeff(-1); // multiply by -1 to all values
        
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
        for(int i = 0; i < poly.size(); i++)
            poly.get(i).multiplyCoeff(s);
        
    } // end scalarMultiply
    
    /*===================================================================================================================================
     |  Method toString
     |
     |        Purpose: Creates a String representation of the current PolynomialB object. The terms are laid out in decreasing order by
     |                 exponent. All coefficients and exponents are displayed and paranthesized and one space is given on either side
     |                 of the addition and subtractions.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: PolynomialB prepares to get transformed into a string. IS IT READY I DONT KNOW EAT MY CHICKEN
     |   Post-Condition: What is ultimately returned is the PolynomialB object in string form.
     |
     |        Returns:  string of polynomial object
     *=================================================================================================================================*/
    public String toString()
    {
        String result = new String("");      // to hold the final string result
        int [] temp = new int[poly.size()];  // int array to hold the exponents in decending order
        int x = 0;                           // temp value to hold an exponent while it is rearranged
        
        if (poly.isEmpty())
        {
            return "(0)x^(0)";
        }
        
        for (int i = 0; i < poly.size(); i++) // puts all exponents in integer array to compare easily and rearrange
            temp[i] = poly.get(i).getExpo();
        
        
        
        /////An Array sort algorithm using two for loops////////////////////////////////////////////
        for(int i = 0; i < poly.size(); i++)
        {
            for (int j = i + 1; j < poly.size(); j++)
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
            for (int j = 0; j < poly.size(); j++) // inner loop holding the polynomial exponents that are compared to the outter one
            {
                if (poly.get(j).getExpo() == temp[i])
                {
                    if (poly.get(j).getCoeff() > 0) // if positive a '+' is placed
                        result = " + " + poly.get(j).toString() + result;
                    
                    else // otherwise it is a ' - '
                        result = " - " + poly.get(j).toString() + result;
                } // end if
                
            } // end inner for
        } // end outter for
        
        if (result.charAt(1) == '+')
            result = result.substring(3, result.length()); // this substring removes the preceding signs
        
        
        
        return result;
    } // end toString
    
    
    /*===================================================================================================================================
     |  Method exponentList
     |
     |        Purpose: Returns a list of the exponents of the current object in the order they are listed in. Only the exponents are
     |                 contained in this list, so this a list of arrays
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: The list is ready to go. Nothing will be changed.
     |   Post-Condition: A list of exponents is created and returned
     |
     |        Returns: theList - list of the expoents of the current object
     *=================================================================================================================================*/
    public List exponentList()
    {
        LinkedList<Integer> theList = new LinkedList<Integer>();
        
        for (int i = 0; i < poly.size(); i++)
            theList.add(poly.get(i).getExpo());
        
        return theList;
    } // end exponentList
} // end class