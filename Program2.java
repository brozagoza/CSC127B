/*=======================================================================================================================================
 |   Assignment:  Program #2: Two's Complement
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  September 14, 2015 9:00pm
 |
 |  Description:  This is a testing program that is to be run with a BinaryNumber class. It tests all constructors, methods, etc. to make
 |                sure they are running properly. The program has a score counter of which a maximum score is 15. When a test is failed,
 |                a print message is displayed with where it failed so the user can make changes. 
 |                
 | Operational :  Dr.Java-20140826-r5761
 | Requirements   Must be used with a java class under the name of BinaryNumber
 |
 | Deficencies :  none
 |
 |                
 *=====================================================================================================================================*/

public class Program2
{
    public static void main (String [] args)
    {
        int score = 0;            // current score of the user
        final int MAX_SCORE = 15; // maximum score one can get... one must pass a series of vigorous test that will reach new limits
        int cat = 0;              // used to test the try/catch
        
        
        System.out.printf("Failed The Following Test:\n");
        
        // Test 1. 1pt
        // Create a new object with the value 0 and an 8-bit capacity.
        BinaryNumber num = new BinaryNumber();
        num.setValue("00000000");
        
        if (num.toString().equals("00000000"))
            ++score;
        else
            System.out.println("Test 1 Failed.");
        ////////////////////////////////////////////////////////////////////////////////////
        
        
        
        // Test 2abc. 3pts
        // Test that the object's value is set to that of a string with same length of bits and at least 4 bits,
        // as well as throwing an exception when there's some funky characters about ; ).
        BinaryNumber num2 = new BinaryNumber("0");
        cat = 0;
        
        //a
        if (num2.toString().equals("0000")) // checks for 4 bit min
            ++score;
        else
            System.out.println("Test 2a Failed.");
        
        //b
        num.setValue("10101010");
        if (num.toString().equals("10101010")) // checks that numbers equal of same bit length
            ++score;
        else
            System.out.println("Test 2b Failed.");
        
        //c
        BinaryNumber num3 = new BinaryNumber();
        try{
            num3.setValue("1234"); // checks that numbers other than 0 & 1 aren't stored
        }
        catch (IllegalArgumentException e){
            ++score;
            cat = 1;
        }
        if (cat == 0)
            System.out.println("Test 2c Failed.");
        ////////////////////////////////////////////////////////////////////////////////////
        
        
        // Test 3. 1pt 
        // Tests to see if the a new string of larger length would be stored in the object's value or if exception
        // would be thrown.
        BinaryNumber num4 = new BinaryNumber();
        num4.setValue("0");
        cat = 0;
        
        try
        {
            num4.setValue("101010");
        }
        catch (IllegalArgumentException e){
            ++score;
            cat = 1;
        }
        if (cat == 0)
            System.out.println("Test 3 Failed.");
        ////////////////////////////////////////////////////////////////////////////////////
        
        
        // Test 5abc. 3pt
        // Test to see if equal will return true or false when compared with objects, regardless of the bit size.
        BinaryNumber num5 = new BinaryNumber("01");
        BinaryNumber num6 = new BinaryNumber("0000000000000000000000000000000000000000001");
        
        //a
        if (num5.equal(num6)) // same two values with different bit sizes
            ++score;
        else
            System.out.println("Test 5a failed.");
        
        //b
        num4.setValue("1");
        if (!(num3.equal(num6))) // simply two different values
            ++score;
        else
            System.out.println("Test 5b failed.");
        
        //c
        num5.setValue("0");
        num4.setValue("0");
        if (num4.equal(num5)) // 1 bit values compared
            ++score;
        else
            System.out.println("Test 5c failed.");
        ////////////////////////////////////////////////////////////////////////////////////
        
        
        
        // Test 6abcd. 
        // Test that incrementation is true.
        cat = 0;
        BinaryNumber num7 = new BinaryNumber("00110"); // 6
        BinaryNumber num8 = new BinaryNumber("00011"); // 3
        
        //a
        num7.incrementBy(num8); // 6 + 3 = 9
        if( num7.toString().equals("01001")) // checks to see if 6 + 3 = 9 in binary
            ++score;
        else
            System.out.println("Test 6a failed.");
        
        
        //b
        num7.setValue("01111"); // 15
        num8.setValue("00001"); // 1
        try{
            num7.incrementBy(num8); // checks to see if adding two positive numbers that turns the sign negative is catched
        }
        catch (ArithmeticException e){
            ++score;
            cat = 1;
        }
        
        if (cat == 0)
            System.out.println("Test 6b Failed.");
        
        
        //c
        num7.setValue("11111"); // -1
        num8.setValue("11111"); // -1
        
        num7.incrementBy(num8); // checks to see if adding two negative numbers with answer possible, would be true
        if (num7.toString().equals("11110"))
            ++score;
        else
            System.out.println("Test 6c failed.");
        
        
        //d
        num7.setValue("10010"); // -14
        num8.setValue("11000"); // -8
        
        num7.incrementBy(num8);
        
        if (num7.toString().equals("01010")) // even though answer is not correct, checks to see that they are still added by guidelines
            ++score;
        else
            System.out.println("Test 6d failed.");
        ////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        // Test 7abc.
        // Test that decrementation is true.
        
        
        //a
        num7.setValue("00110"); // 6
        num8.setValue("00011"); // 3
        
        num7.decrementBy(num8);
        if (num7.toString().equals("00011"))  // checks to see that 6 - 3 = 3
            ++score;
        else
            System.out.println("Test 7a failed.");
        
        
        //b
        num7.setValue("10001"); // -15
        num8.setValue("11011"); // -5
        
        num7.decrementBy(num8);
        if (num7.toString().equals("10110")) // checks to see that -15 - (-5) = -10
            ++score;
        else
            System.out.println("Test 7b failed.");
        
        //c
        BinaryNumber num9 = new BinaryNumber("111111");
        BinaryNumber num10 = new BinaryNumber("100000");
        
        num9.decrementBy(num9);
        if (num9.toString().equals("000000")) // since an extra bit was not available, loss of precision. But this should result.
            ++score;
        else
            System.out.println("Test 7c failed.");
        ////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        
        if (score == MAX_SCORE)
            System.out.printf("Actaully just kidding, not tests have failed.\n\n");
        
        
        System.out.printf("Final Score: %d of %d\n", score, MAX_SCORE);
        
    } // end main
} // end class