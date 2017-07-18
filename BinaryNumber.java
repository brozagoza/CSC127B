/*=================================================================================================================================*
 ||
 ||  Class BinaryNumber 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class holds an object's value in binary form and
 ||                  as a string. This class was written to perform mulitple
 ||                  tasks with binary numbers such as adding, subtracting,
 ||                  and many more.
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
import java.nio.BufferOverflowException;

public class BinaryNumber {
    String value = new String(""); 
    
    /*===================================================================================================================================
     |  Constructor BinaryNumber
     |
     |        Purpose: Sets the new object's value to 0 with an 8-bit capacity. This constructor is automatically called when declaring a 
     |                 new BinaryNumber. This constructor is only called once.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: Value may be empty or contains other random numbers.
     |   Post-Condition: Value will contain '0' in an 8-bit binary form because no numbers were called in.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public BinaryNumber ()
    {
        this.value = "00000000"; // sets value to 8-bit capacity all as '0's as default
    } // end BinaryNumber construct
    
    
    
    /*===================================================================================================================================
     |  Constructor BinaryNumber
     |
     |        Purpose: Constructor that declares the value to be whatever is passed in as a string to be stored as the object's value.
     |
     |     Parameters: String str -- the value passed in as a string to be the value of this object
     |
     |    Pre-Condition: The object's value would have been defaulted to 8-bit '0's but is currently empty.
     |   Post-Condition: The object's value will contain the string that is passed in as a binary number.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public BinaryNumber(String str)
    {   
        for (int i = 0; i < str.length(); i++) // checks to see if the string contains characters other than '0' and '1'
        {
            
            if (!( str.charAt(i) == '1' || str.charAt(i) == '0') ) // if the string passed in isn't just '0's and '1's throw exception
                throw new IllegalArgumentException();
            
        } // end for loop
        
        
        value = ""; // resets the value of the object to nothing
        
        if (str.length() < 4) // if the binary number passed in is less than 4 bit it will add bits to reach 4bit minimum
        {
            for (int i = 0; i < 4 - str.length(); i++)
            {
                value = value + "0"; // add the extra bits until 4bit is reached
            }
            value = value + str; // finally adds the string value to the object's value
        } // end if
        else
            value = "" + str; // if the length of the string is sufficient, simply change "value"
        
        
    } // end BNstring
    
    
    /*===================================================================================================================================
     |  Method setValue
     |
     |        Purpose: Replaces the value of the object with the binary value of the string passed in, not altering object length. If the
     |                 string passed in is of larger bit than the object's value an Arugment Exception is thrown.
     |
     |     Parameters: String str -- the new binary value passed in as a string
     |
     |    Pre-Condition: The obejct will contain any value in whatever bits it previously contained before altering it.
     |   Post-Condition: If the string passed in 'fits' into the object's value, then the value is changed into the string. If not,
     |                   then Arithmetic Exception is thrown.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public void setValue(String str)
    {
        if (str.length() > this.value.length())
        {
            throw new IllegalArgumentException();
        } // end if
        
        for (int i = 0; i < str.length(); i++) // checks to see if the string contains characters other than '0' and '1'
        {
            
            if (!( str.charAt(i) == '1' || str.charAt(i) == '0') ) // if the string passed in isn't just '0's and '1's throw exception
                throw new IllegalArgumentException();
            
        } // end for loop
        
        
        value = ""; // resets the value of the object to nothing
        
        if (str.length() < 4) // if the binary number passed in is less than 4 bit it will add bits to reach 4bit minimum
        {
            for (int i = 0; i < 4 - str.length(); i++)
            {
                value = value + "0"; // add the extra bits until 4bit is reached
            }
            value = value + str; // finally adds the string value to the object's value
        } // end if
        else
            value = "" + str; // if the length of the string is sufficient, simply change "value"
        
    } // end setVal
    
    
    /*===================================================================================================================================
     |  Method toString
     |
     |        Purpose: Returns the object's value as a string. Since value is already a string, it is returned as is.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: Value is already a string so method remains same pre and post.
     |   Post-Condition: Value is already a string so method remains same pre and post.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/ 
    public String toString()
    {
        
        return value;
    } // end toString
    
    
    /*===================================================================================================================================
     |  Method equal
     |
     |        Purpose: Returns true/false if the value passed in matches that of the object's value. If either is of shorter bit than
     |                 the other, extra zeros are added so that they are of same bit length.
     |
     |     Parameters: BinaryNumber numba -- the object containing the comparing value
     |
     |    Pre-Condition: Value to compare to is passed in. Nothing will be altered.
     |   Post-Condition: Program returns true/false depending if the values equal or not. Nothing is altered.
     |
     |        Returns:  true/false
     *=================================================================================================================================*/
    public boolean equal(BinaryNumber numba)
    {
        String valueTest = new String(""); // string is used so value can have same bits as numba for comparing purposes
        String numbaTest = new String(""); // string if used so numba can have same bits as value for comparing purposes
        
        
        if (value.length() < numba.value.length()) // if the value object is less than the comparing number extra 0's added
        {
            for(int i = 0; i < numba.value.length() - value.length(); i++)
            {
                valueTest = valueTest + "0";
            } // end for loop
            valueTest = valueTest + this.value; // adds the 0s and the actual value to be tested
            
            if (valueTest.equals(numba.value))
                return true;
            else
                return false;
        }
        
        
        else if (numba.value.length() < value.length()) // if the numba object is less than value extra 0's added
        {
            for (int i = 0; i < value.length() - numba.value.length(); i++)
            {
                numbaTest = numbaTest + "0";
            } // end for loop
            numbaTest = numbaTest + numba.value; // adds the 0s and the actual value to be tested
            
            if (numbaTest.equals(this.value))
                return true;
            else
                return false;
        }
        else
        {
            if(numba.value.equals(this.value)) // since the two objects are the same size, they are just compared
                return true;
            else
                return false;
        }
        
        
    } // end equal
    
    
    /*===================================================================================================================================
     |  Method incrementBy
     |
     |        Purpose: Increments the object's value by the value of the object that is passed in. The object's value that is passed in
     |                 must be of same bit length or shorter in order to be added otherwise BufferOverflowException is thrown. If both
     |                 values are positive and the resulting value is negative due to a leading '1,' then ArithmeticException is thrown.
     |                 
     |
     |     Parameters: BinaryNumber numba -- conatins the value that is to be incremented into the object's value.
     |
     |        Returns: (void)
     *=================================================================================================================================*/ 
   public void incrementBy(BinaryNumber numba)
    {
       final int SIZE = this.value.length();          // holds bit length of the object's value
       char[] answer = new char[SIZE];                // will hold the resulting numbers
       
       if (numba.value.length() > this.value.length())
            throw new BufferOverflowException();            // if the number being added is of larger bit than the object
        
        while ( numba.value.length() < this.value.length()) // adds preceding zeros so adding is cleaner
            numba.value = "0" + numba.value;
        
        for (int i = 1; i <= SIZE; i++)                     // this loop adds two values using certain meaning for resulting numbers
        {
            if (value.charAt(SIZE - i) == '0' && numba.value.charAt(SIZE - i) == '0') 
                answer[SIZE - i] = '0'; 
            
            if (value.charAt(SIZE - i) == '1' && numba.value.charAt(SIZE - i) == '0' ||
                value.charAt(SIZE - i) == '0' && numba.value.charAt(SIZE - i) == '1')
                answer[SIZE - i] = '1'; 
            
            if (value.charAt(SIZE - i) == '1' && numba.value.charAt(SIZE - i) == '1')
                answer[SIZE - i] = '2';                     // 1 + 1 = 10, so 2 signifes the "carry" for a later loop
        } // end for loop
        
        for (int i = 1; i <= SIZE; i++)                     // this loop goes through the results and converts them to binary
        {
            if (answer[SIZE - i] == '3')                    // 1 + 1 + 1 = 11, marked as a 3 for this loop
            {
                answer[SIZE - i] = '1';
                if (i != SIZE)
                    ++answer[SIZE - (i+1)];
            }
            if (answer[SIZE - i] == '2')                    // 1 + 1 = 10, marked as a 2 for this loop
            {
                answer[SIZE - i] = '0';
                if (i != SIZE)
                    ++answer[SIZE - (i+1)];
            }
        } // end for loop
        
        if(value.charAt(0) == '0' && numba.value.charAt(0) == '0' && answer[0] == '1') // if two positive numbers turn negative
            throw new ArithmeticException();
        
        String answerStr = new String(answer);           // passes in the character array to a final string
        this.value = answerStr;
        
        
        
        
    } // end incrementBy
    
    
    
    
    /*===================================================================================================================================
     |  Method decrementBy
     |
     |        Purpose: Decrements the object's value by the value of the object that is passed in. The object's value that is passed in
     |                 must be of same bit length or shorter in order to be subtracted otherwise BufferOverflowException is thrown. If 
     |                 both values are positive and the resulting value is negative due to a leading '1,' then ArithmeticException is 
     |                 thrown.
     |
     |     Parameters: BinaryNumber numba - conatins the value that is to be decremented into the object's value.
     |
     |        Returns: (void)
     *=================================================================================================================================*/ 
    public void decrementBy(BinaryNumber numba)
    {
        final int SIZE = this.value.length();               // holds bit length of the object's value
        char[] twoComp = new char[SIZE];                    // holds the subtracting value in two's complement form
        char[] answer = new char[SIZE];                     // will hold the resulting numbers
        BinaryNumber one = new BinaryNumber("1");           // literally just the number 1 so that it can be added for two's comp later
       
        
        
        if (numba.value.length() > this.value.length())
            throw new BufferOverflowException();            // if the number being added is of larger bit than the object
        
        while ( numba.value.length() < this.value.length()) // adds preceding zeros so subtracting is cleaner
            numba.value = "0" + numba.value;
        
        
        
        for (int i = 0; i < SIZE; i++)                      // flips the numbers of the subtracting value
        {
            if (numba.value.charAt(i) == '1')
                twoComp[i] = '0';
            
            if (numba.value.charAt(i) == '0')
                twoComp[i] = '1';
        } // end for loop
        
        
        String twoCompStr = new String(twoComp);               // holds twoComp as string (currently before adding 1)
        BinaryNumber answerBN = new BinaryNumber(twoCompStr);  // declares temporary BinaryNumber so that incrementBy can be used
        
        answerBN.incrementBy(one);                             // increments twoComp by 1 so that it holds the true two's comp value
        twoCompStr = answerBN.toString();                      // holds final two's complement value
        
        
        
        
        for (int i = 1; i <= SIZE; i++)                        // this loop adds two values using certain meaning for resulting numbers
        {
            if (value.charAt(SIZE - i) == '0' && twoCompStr.charAt(SIZE - i) == '0') 
                answer[SIZE - i] = '0'; 
            
            if (value.charAt(SIZE - i) == '1' && twoCompStr.charAt(SIZE - i) == '0' ||
                value.charAt(SIZE - i) == '0' && twoCompStr.charAt(SIZE - i) == '1')
                answer[SIZE - i] = '1'; 
            
            if (value.charAt(SIZE - i) == '1' && twoCompStr.charAt(SIZE - i) == '1')
                answer[SIZE - i] = '2';                     // 1 + 1 = 10, so 2 signifes the "carry" for a later loop
        } // end for loop
        
        
        for (int i = 1; i <= SIZE; i++)                     // this loop goes through the results and converts them to binary
        {
            if (answer[SIZE - i] == '3')                    // 1 + 1 + 1 = 11, marked as a 3 for this loop
            {
                answer[SIZE - i] = '1';
                if (i != SIZE)
                    ++answer[SIZE - (i+1)];
            }
            if (answer[SIZE - i] == '2')                    // 1 + 1 = 10, marked as a 2 for this loop
            {
                answer[SIZE - i] = '0';
                if (i != SIZE)
                    ++answer[SIZE - (i+1)];
            }
        } // end for loop
        
        if(value.charAt(0) == '0' && twoCompStr.charAt(0) == '0' && answer[0] == '1') // if two positive numbers turn negative
            throw new ArithmeticException();
        
        String answerStr = new String(answer);
        this.value = answerStr;
        
        

    } // end decrementBy
    
    
    
    
    
    
} // end class