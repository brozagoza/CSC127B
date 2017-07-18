/*=======================================================================================================================================
 |   Assignment:  Program #9: A Recursion Half-Dozen
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  November 12th, 2015 9:00pm
 |
 |  Description:  This program is a tester for the Recursion class. This assignment was simply to gain practice using recursive
 |                functions. Some functions are simple and some are complex.
 |                
 | Operational :  
 | Requirements   
 |
 | Deficencies :  none
 |                
 *=====================================================================================================================================*/
    import java.util.Arrays;
    
class Prog09
{
    public static void main(String [] args)
    {
        Recursion test = new Recursion(); // declare a test object
        int score = 0;
        final int MAX_SCORE = 12;
        
        
        
        
        /*=========  Tests Greatest Common Divisor ===========*/
        // Test 1a.
        if (test.gcd(12, 15) == 3)
            ++score;
        else
            System.out.println("Test 1A failed. gcd(12, 15) is "+test.gcd(12,15)+" should be 3.");
        
        // 1b.
        if (test.gcd(7,14) == 7)
            ++score;
        else
            System.out.println("Test 1B failed. gcd(7, 14) is "+test.gcd(7,14)+" should be 7.");
        
        // 1c.
        if (test.gcd(52, 65) == 13)
            ++score;
        else
            System.out.println("Test 1C failed. gcd(52, 65) is "+test.gcd(52,65)+" should be 13.");
        
        
        
        
        /*=========  Tests Ackermann's Function ===========*/
        // Test 2a.
        if (test.ackermann(2,4) == 11)
            ++score;
        else
            System.out.println("Test 2A failed. ackermann(2,4) is "+test.ackermann(2,4)+" should be 11.");
        
        // Test 2b.
        if (test.ackermann(1,3) == 5)
            ++score;
        else
            System.out.println("Test 2B failed. ackermann(1,3) is "+test.ackermann(1,3)+" should be 5.");
        
        // Test 2c.
        if (test.ackermann(1,1) == 3)
            ++score;
        else
            System.out.println("Test 2C failed. ackermann(1,1) is "+test.ackermann(1,1)+" should be 3.");
        
        
        
        
        
        /*=========  Tests String Reversal ===========*/
        // Test 3a.
        if (test.reverse("hello").equals("olleh"))
            ++score;
        else
            System.out.println("Test 3A failed. Reverse(\"hello\") is " +test.reverse("hello")+" should be olleh.");
        
        // Test 3b.
        if (test.reverse("GoogleDotCom").equals("moCtoDelgooG"))
            ++score;
        else
            System.out.println("Test 3B failed. Reverse(\"GoogleDotCom\") is " +test.reverse("GoogleDotCom")+" should be moCtoDelgooG.");
        
        // Test 3c.
        if (test.reverse("taco").equals("ocat"))
            ++score;
        else
            System.out.println("Test 3C failed. Reverse(\"taco\") is " +test.reverse("taco")+" should be ocat.");
        
        
        
        /*=========  Tests Range Sum ===========*/
        double[] sum = {7, -2, 4, 0, 8, -1, 2};
        
        // Test 4a.
        if (test.rangeSum(sum, 1,4) == 10)
            ++score;
        else
            System.out.println("Test 4A failed. rangeSum(1,4) is "+test.rangeSum(sum, 1,4)+" should be 10.");
        
        // Test 4b.
        if (test.rangeSum(sum, 5,5) == -1)
            ++score;
        else
            System.out.println("Test 4B failed. rangeSum(5,5) is "+test.rangeSum(sum, 5,5)+" should be -1.");
        
        // Test 4a.
        if (test.rangeSum(sum, 6,5) == 0)
            ++score;
        else
            System.out.println("Test 4C failed. rangeSum(6,5) is "+test.rangeSum(sum, 6,5)+" should be 0.");
        
        
        
        /*=========  Tests Pascal's Triangle ===========*/
        int[] t1 = {1};
        int[] t2 = {1,4,6,4,1};
        int[] t3 = {1,5,10,10,5,1};
        
        // Test 5a.
        if (Arrays.toString(test.pascalRow(4)).equals(Arrays.toString(t2)))
            ++score;
        else
            System.out.println("Test 5A failed. pascalRow(4) is "+Arrays.toString(test.pascalRow(4)));
        
        // Test 5b.
        if (Arrays.toString(test.pascalRow(5)).equals(Arrays.toString(t3)))
            ++score;
        else
            System.out.println("Test 5B failed. pascalRow(5) is "+Arrays.toString(test.pascalRow(5)));
        
        // Test 5c.
        if (Arrays.toString(test.pascalRow(0)).equals(Arrays.toString(t1)))
            ++score;
        else
            System.out.println("Test 5C failed. pascalRow(0) is "+Arrays.toString(test.pascalRow(0)));
        
        
        
        // Prints final score
        System.out.println("Total score is "+score+" of "+MAX_SCORE);
    }
} // end Prog09