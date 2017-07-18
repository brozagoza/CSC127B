/*=======================================================================================================================================
 |   Assignment:  Program #4: PolynomialA
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  October 1, 2015 9:00pm
 |
 |  Description:  This program tests the PolynomialA class that is to be written and included with this file. THe polynomial class includes
 |                severl super cool methods that perform tasks such as evaluating, toString, and more (check that class header for more info)
 |                This is a testing program that should work on all PolynomialA classes alike.
 |                
 | Operational :  Dr.Java-20140826-r5761
 | Requirements   User must simply click 'run'.
 |
 | Deficencies :  none
 |
 |                
 *=====================================================================================================================================*/
class Prog4
{
  public static void main (String [] args)
  {
    System.out.printf("What is going on bruhs time for the single best tester program in the entire world! YASSS!!\n");
    int score = 0;
    final int MAX_SCORE = 20;
    
    // Test 1 my brothers - test addTerm and the toString method
    PolynomialA test1 = new PolynomialA();
    test1.addTerm(5,2);
    
    if("(5)x^(2)".compareTo(test1.toString()) == 0)
      score++;
    else
      System.out.println("Test 1 failed.");
    
    // Test 2 my brothers - test addTerm and the toString method now with two terms
    test1.addTerm(3,6);
    
    if("(3)x^(6) + (5)x^(2)".compareTo(test1.toString()) == 0)
      score++;
    else
      System.out.println("Test 2 failed.");
    
    // Test 3 my sisters - Negative coefficents as well as exponent 0 is entered. Testing the reverse order.
    PolynomialA test2 = new PolynomialA();
    
    test2.addTerm(-5,-1);
    test2.addTerm(3,0);
    test2.addTerm(6,23);
    
    if ("(6)x^(23) + (3)x^(0) - (5)x^(-1)".compareTo( test2.toString()) == 0)
      score++;
    else
      System.out.println("Test 3 failed.");
    
    // Test 4 - Tests addTerm with the same exponent..
    PolynomialA test3 = new PolynomialA();
    
    test3.addTerm(-5,23);
    test3.addTerm(3,23);
    test3.addTerm(6,23);
    
    if ("(4)x^(23)".compareTo( test3.toString()) == 0)
      score++;
    else
      System.out.println("Test 4 failed.");
    
    // Test 5 - Test holding 2 terms (assumes last test was working-ish)
    test3.addTerm(5,2);
    
    if ( test3.holding() == 2 )
      score++;
    else
      System.out.println("Test 5 failed.");
    
    // Test 6 - Lets do holding again, but with some negative my friends hahah i still have to study for physics NO SLEEP
    test3.addTerm(45, -1243);
    
    if (test2.holding() == 3)
      score++;
    else
      System.out.println("Test 6 failed.");
    
    // Test 7 - Lets test adding an entire POLYNOMIAL WOOWOOOWOOOOOOO
    PolynomialA test4 = new PolynomialA();
    PolynomialA test5 = new PolynomialA();
    
    test4.addTerm(5,2);
    test5.addTerm(6,3);
    
    test4 = test4.add(test5);
    
    if ("(6)x^(3) + (5)x^(2)".compareTo(test4.toString()) == 0)
      score++;
    else
      System.out.println("Test 7 failed." + test4.toString());
    
    // Test 8 - Lets do add again... BUT CRAZY WHAT WE ARE CRAZY ARENT WE NO SLEEP LETS DO THIS COMPPPP
    test5.addTerm(9,1);
    test5.addTerm(8,-2);
    test4 = test4.add(test5);
    
    if ("(12)x^(3) + (5)x^(2) + (9)x^(1) + (8)x^(-2)".compareTo(test4.toString()) == 0)
      score++;
    else
      System.out.println("Test 6 failed." + test4.toString());
    
    
    // Test 9 - Lets do some Scalarmultiply testing my brothers WHO WANTS TO MEET FOR SOME ORANGE CHICKEN
    PolynomialA test6 = new PolynomialA();
    test6.addTerm(5,2);
    test6.addTerm(2,1);
    test6.addTerm(10,0);
    
    test6.scalarMultiply(2);
    if ("(10)x^(2) + (4)x^(1) + (20)x^(0)".compareTo( test6.toString() ) == 0)
      score++;
    else
      System.out.println("Test 9 failed.");
    
    // Test 10 - Same thang as above but with negative values my friend
    test6.scalarMultiply(-2);
    if (" - (20)x^(2) - (8)x^(1) - (40)x^(0)".compareTo( test6.toString() ) == 0)
      score++;
    else
      System.out.println("Test 10 failed.");
    
    // Test 11 - Lets do some empty testing my friends I LOVE YOU
    PolynomialA test7 = new PolynomialA();
    if(test7.isEmpty())
      score++;
    else
      System.out.println("Test 11 failed.");
    
    // Test 12 - Same thang but must be false now WHAT WHAT
    test7.addTerm(5,2);
    if(!test7.isEmpty())
      score++;
    else
      System.out.println("Test 12 failed.");
    
    
    // Test 13 - Test is full (SHOUDL ALWAYSSS BE FALSEEZZE)
    if(!test7.isFull())
      score++;
    else
      System.out.println("Test 13 failed.");
    
    // Test 14 - LETS GET SOME COEFFICENTS NOW MUAHAHAHAHA
    if (test7.getCoefficient(2) == 5)
      score++;
    else
      System.out.println("Test 14 failed.");
    
    
    // Test 15 - time to evalute these little guys
    PolynomialA test8 = new PolynomialA();
    test8.addTerm(1,2);
    test8.addTerm(5,1);
    test8.addTerm(10,0);
    
    if (test8.evaluate(2) == 24)
      score++;
    else
      System.out.println("Test 15 failed.");
    
    // Test 16 - Another evalute case... im already up this late.. whats an all nighter am i right?
    PolynomialA test9 = new PolynomialA();
    test9.addTerm(5,7);
    test9.addTerm(2,-4);
    test9.addTerm(1,0);
    
    if (test9.evaluate(7) ==4117716.000832986)
      score++;
    else
      System.out.println("Test 16 failed. ");
    
    // Test 17 - LETS DO SOME NEGATION ARE YOU READY I KNOW I AM
    test9.negate();
    
    if (" - (5)x^(7) - (1)x^(0) - (2)x^(-4)".compareTo(test9.toString()) == 0)
      score++;
    else
      System.out.println("Test 17 failed. ");
    
    // Test 18 - equals is the test at hand... oh yes it is
    if (!test1.equals(test9))
      score++;
    else
      System.out.println("Test 18 failed. ");
    
    // Test 19 - another equls but this time for true
    test1 = test9;
    if (test1.equals(test9))
      score++;
    else
      System.out.println("Test 19 failed. ");
    
    // Test 20 - REPLICATE TEST
    PolynomialA test10 = test1.replicate();
    
    if (test10.toString().compareTo(test1.toString()) == 0)
      score++;
    else
      System.out.println("Test 20 failed. ");
    
    
    // see you in the next episode LOVE YAH SWWEEET THANG
    
    
    
    
    // END RESULT
    System.out.println("\nScored " + score +" out of " +MAX_SCORE);
  } // end main
} // end class
