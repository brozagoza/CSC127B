import java.util.*; // imports array list to be used in this program my brothers let us begin the fight LETS US MARCH INTO WAR
/*=================================================================================================================================*
 ||
 ||  Class PolynomialA 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class holds an object known as a PolynomialA which is simply an ArrayList of "Terms" (another class).
 ||                  This class contains several methods to hold polynomialAs and perform multiple actions with them.
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
 ||   Constructors:  PolynomialA()
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  add(PolynomialA)
 ||                  addTerm(int, int)
 ||                  replicate()
 ||                  equals(PolynomialA)
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
class PolynomialA implements Quantity
{
    private ArrayList<Term> poly; // the polynomialA BROTHERS
    
    
    /*===================================================================================================================================
     |  Constructor PolynomialA
     |
     |        Purpose: Initializes a new polynomialAB object as an ArrayList
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Object is created.
     |
     *=================================================================================================================================*/ 
    PolynomialA()
    {
        poly = new ArrayList<Term>();
    }
    
    
    /*===================================================================================================================================
     |  Method add
     |
     |        Purpose: Mathematically adds the polynomialAA 'p' to the current PolynomialA, returning a new PolynomialA object. Neither of
     |                 the existing PolynomialA objects are changed. If both PolynomialAs possess terms with matching exponents, sum each
     |                 pair of matching terms.
     |
     |     Parameters: PolynomialA p - the polynomialA to be added to the current polynomialA object.
     |
     |    Pre-Condition: PolynomialA p is passed in but will not be changed and neither will the current object polynomialA.
     |   Post-Condition: PolynomialA object result contains the addition of two polynomialAs but none have been altered.
     |
     |        Returns:  result - the polynomialA with the results in it
     *=================================================================================================================================*/ 
    public PolynomialA add(PolynomialA p)
    {   
        PolynomialA result = new PolynomialA();
        
        for (int i = 0; i < poly.size(); i++) // sets all the objects from this polynomialA into the resulting one
            result.addTerm(poly.get(i).getCoeff(), poly.get(i).getExpo());
        
        List<Integer> resultExpos;
        resultExpos = p.exponentList(); // contains the list of exponents
        
        for (int i = 0; i < resultExpos.size(); i++) // adds all the new terms from the new polynomialA
            result.addTerm(p.getCoefficient(resultExpos.get(i)), resultExpos.get(i) );
        
        
        return result;
    } // end add
    
    
    /*===================================================================================================================================
     |  Method addTerm
     |
     |        Purpose: Mathematically adds a term to the polynomialA object with coefficent 'c' and exponent 'e'. If a term with exponent
     |                 'e' already exists, then the terms are summed and replace the old coefficent with the new sum.
     |
     |     Parameters: int c - the coefficent being passed in
     |                 int e - the exponent being passed in
     |
     |    Pre-Condition: The PolynomialA object is ready to be altered for some good ol fashion fun. Int c and e are ready to party.
     |   Post-Condition: After that crazy party, this PolynomialA object now has been infected with int C and int E. What a wild night.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void addTerm(int c, int e)
    {
        boolean expoExists = false;    // to check if a term with exponent 'e' already exists
        Term newTerm = new Term(c, e); // creates a new Term for the polynomialA
        Term tempTerm;
        ArrayList<Term> polyTemp = new ArrayList<Term>();                  // to hold the resulting PolynomialA object
        
        if (poly.isEmpty())          // if the polynomialA is empty
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
     |        Purpose: Creates a new PolynomialA object that posses a copy of the current PolynomialA using a completely new collection of
     |                 objects.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: The PolynomialA object is ready to copied into another PolynomialA object. This should be grand.
     |   Post-Condition: PolynomialA object now has an exact clone! Who can tell the difference? Not many can. Tune in next week for more.
     |
     |        Returns:  copy - exact clone of current PolynomialA object
     *=================================================================================================================================*/
    public PolynomialA replicate()
    {
        PolynomialA copy = new PolynomialA();
        copy.poly = poly;
        
        return copy;
        
    } // end replicate
    
    
    
    /*===================================================================================================================================
     |  Method equals
     |
     |        Purpose: Returns true if PolynomialA being passed in has the same number of non-zero terms with the same coefficents and
     |                 same exponents as this PolynomialA object. Otherwise it is false. In other words, they must be CLONES!!!!!!!!!
     |
     |     Parameters: PolynomialA p - the polynomialA object to be tested against this object. i hope it's ready for the test of a lifetim
     |
     |    Pre-Condition: The PolynomialA object is ready to copied into another PolynomialA object. This should be grand. PART 2
     |   Post-Condition: PolynomialA object now has an exact clone if it was true! Otherwise false is returned
     |
     |        Returns:  true/false
     *=================================================================================================================================*/
    public boolean equals(PolynomialA p)
    {
        int trueCount = 0; // holds the count of truths so far in the polynomialA
        
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
     |        Purpose: Evaluates this PolynomialA object on the value 'x' that is passed in. Returns the result of the evaluation. This is
     |                 quite the grand code my friends HAHAHAHA well then.
     |
     |     Parameters: double x - the value 'x' that the PolynomialA will be evaluated at
     |
     |    Pre-Condition: The PolynomialA prepares to get taken in the 'x' value to be evaluated with
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
     |    Pre-Condition: PolynomialA object is ready to send them that exponent of beauty.
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
     |        Purpose: Resturns true if the PolynomialA currently holds no terms, false otherwise.
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
     |        Purpose: Resturns true if the PolynomialA currently has no available space for additional terms, false otherwise.
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
     |        Purpose: Resturns the number of terms with non-zero coefficients that are currently in the PolynomialA.
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
     |        Purpose: Creates a new PolynomialA of new objects that has the same number of terms with the same exponents as does the
     |                 current PolynomialA object, but all the signs on the coefficents are switched. Essentially a negative sign was
     |                 slapped in front of the whole thing like -(polynomialA).
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: The polynomialA object is ready to be negated. Don't worry though, it won't get overwritten there'll be a new one
     |   Post-Condition: The new polynomialA object contains the negate version of the current polynomialA object.
     |
     |        Returns:  negatedPoly - the polynomialA object negated
     *=================================================================================================================================*/
    public PolynomialA negate()
    {
        PolynomialA negatedPoly = new PolynomialA(); // to hold the negated version of the polynomialA
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
     |    Pre-Condition: The polynomialA object is ready to get multipled by the term s.
     |   Post-Condition: The polynomialA object now contains new coefficents that were multiplied by the term s.
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
     |        Purpose: Creates a String representation of the current PolynomialA object. The terms are laid out in decreasing order by
     |                 exponent. All coefficients and exponents are displayed and paranthesized and one space is given on either side
     |                 of the addition and subtractions.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: PolynomialA prepares to get transformed into a string. IS IT READY I DONT KNOW EAT MY CHICKEN
     |   Post-Condition: What is ultimately returned is the PolynomialA object in string form.
     |
     |        Returns:  string of polynomialA object
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
            for (int j = 0; j < poly.size(); j++) // inner loop holding the polynomialA exponents that are compared to the outter one
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
        ArrayList<Integer> theList = new ArrayList<Integer>();
        
        for (int i = 0; i < poly.size(); i++)
            theList.add(poly.get(i).getExpo()); // add the exponent of the object into the list
        
        return theList;
    } // end exponentList
} // end class