/*
*  Test cases for assignment 1 for cs127b Fall 2015
*  These test cases will account for 75% of the grade for this homework
*  The last 25% will be based on style considerations
*  If you're unfamiliar with writing your own test cases I've
*  added a hopefully helpful tips throughout to help you think about
*  testing, remember eventually all the testing will be on you alone.
*  So if you think it will help take some time to look at this code
*  and get some ideas on how to test.
*/

import java.util.Random;
import java.lang.StringBuilder;
public class Assg1Test
{
    public static void main(String[] args)
    {
         //Points are added to correct as they accrue
         int correct = 0;
         //Total is out of 38
         final int TOTAL = 38;
         //Month strings for testing getMonthAsString() and other tests
         String[] months =
                {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"};


         StringBuilder error = new StringBuilder();
         error.append("Failed the following test cases:\n");
         
         //1: Test the new Year!
         
         /* 
         * Test something simple first, just any date with no special 
         * cases. Make sure your formatting and other output is 
         * correct and that it simply compiles and runs without error.
         * This is also conveniently one extreme of the year so that is         * being tested as well
         */

         CalendarDate newYear = new CalendarDate(2000, 1, 1);
         if ( newYear.toString().equals("January 1, 2000") )
            correct += 4;
         else
            error.append("Failed Test 1\n");
 

         //2: Test the New Year's Eve!  
         //Now we are testing the other extreme, the end of the year.
         CalendarDate newYearsEve = new CalendarDate(1999,12,31);
         if ( newYearsEve.toString().equals("December 31, 1999") )
            correct += 2;
         else
            error.append("Failed Test 2\n");

         //3: Test the inevitable passage of time!
         /*
         * A big test, by testing tomorrow() on this we are checking
         * that basically everything rolls over fine.
         * This is important because it effectively will show us if all         * of your code works together. All the moving parts fit.               * It is important to try to find big cases like this when    
	 * testing.
         */ 
         if ( newYearsEve.tomorrow().equals( newYear ) )
            correct += 4;
         else
            error.append("Failed Test 3\n");
         
         //4: Test getDay()
         //Now start testing smaller chunks, try to narrow it as much
         //as possible. 
         if ( newYear.getDay() == 1 )
            correct += 2;
         else
            error.append("Failed Test 4\n");

         //5: Test getMonth()
         if ( newYear.getMonth() == 1 )
            correct += 2;
         else 
            error.append("Failed Test 5\n");

         //6: Test getYear()
         if ( newYear.getYear() == 2000 )
            correct += 2;
         else
            error.append("Failed Test 6\n");

         //7: Test Range control on year
         //If you have to do argument checking always write cases
         //that will test that you are doing that correctly 
         CalendarDate rangeTest = new CalendarDate(1000, -30, 399);
         if ( rangeTest.getYear() == 1753 )
            correct += 2;
         else
            error.append("Failed test 7\n");
         
         //8: Test Range control on month
         if ( rangeTest.getMonth() == 1 )
            correct += 2;
         else 
            error.append("Failed test 8\n");
        
         //9: Test Range control on day
         if ( rangeTest.getDay() == 31 )
            correct += 2;
         else
            error.append("Failed test 9\n");

         //10: Test set date
         CalendarDate testSet = new CalendarDate(300300, 2123123, 123123);
         CalendarDate birthday = new CalendarDate(1989, 7, 11);
         testSet.setDate(1989, 7, 11);
         if ( testSet.equals(birthday) )
            correct += 2;
         else
            error.append("Failed test 10\n");

         //11: getMonthAsString() testing:
         //This method is still small enough that we can do brute force
         //Checking that it is working, tends to be a good idea to help
         //Avoid little typos and things like that with string handling
         int monthScore = 0;
         for(int i = 1; i < 13; i++ )
         {
            CalendarDate current = new CalendarDate(2000, i, 20);
            if( current.getMonthAsString().equals(months[i - 1] ) )
               monthScore++;
            else
               error.append(String.format("The string for month %s is incorrect", months[i - 1]));
         }
         correct += (monthScore / 4 );

         //12: Checking for proper leap year:
         /*
         *Edge case testing. Leap years are the major weird case
         *for this assignment but there are always edge cases.
         *Try to think the hardest about these, the strange special
         *cases that require extra work on your part to handle. Always
         *give these special attention.
         */

         CalendarDate leapYear = new CalendarDate(2012, 2, 30);
         if( leapYear.getDay() == 29 )
             correct += 2;
         else error.append("Failed test 12\n");
   
         //13: Checking for improper leap year:
         CalendarDate commonYear = new CalendarDate(2011, 2, 29);
         if( commonYear.getDay() == 28 )
             correct += 2;
         else error.append("Failed test 13\n");
        
         //14: Checking for edge case for leap year when year is
         // divisible by 100 but not 400
         CalendarDate falseLeap = new CalendarDate(1900, 2, 29);
         if ( falseLeap.getDay() == 28 )
             correct += 2;
         else error.append("Failed test 14\n");

         //15: Checking roll over into leap year
         CalendarDate leapTomorrow = new CalendarDate(2012, 2, 28);
         if ( leapTomorrow.tomorrow().getDay() == 29 )
             correct += 2;
         else error.append("Failed test 15\n");
   
         //16:Checking proper roll without leap year
         CalendarDate noLeap = new CalendarDate(2011, 2, 28);
         CalendarDate noLeapCheck = new CalendarDate(2011, 3, 1);
         if ( noLeap.tomorrow().equals(noLeapCheck ) )
             correct += 2;
         else error.append("Failed test 16\n");


         //17: Last bit of random testing
         /* 
         * This is a final thing I like doing. It will usually be 
         * incredibly difficult to completely prove your system 
         * works for all cases. But running randomized tests is a quick
         * and efficient way to check for unusual cases that you have
         * not thought of. I often find at least one error by doing 
         * this and I find it to be an overall good stress test.
         */

         int points = 1;
         for( int i = 0; i < 100 && points > 0; i++)
         {
              int[] date = randomDate();
              CalendarDate temp = 
                  new CalendarDate(date[0], date[1], date[2]);
              String randDate = String.format("%s %d, %d", 
                        months[date[1] - 1], date[2], date[0]);
              if( !temp.toString().equals(randDate) )
              {
                  points--;
                  error.append(String.format("Test failed on date: %s",                               randDate));
              }
         } 
         correct += points;

         //Output Final Score;
         error.append(String.format("Final Score: %d out of %d", correct, TOTAL));
         System.out.println(error);
         
         
    }

    //Don't be afraid to even make methods that are only to help testing.
    public static int[] randomDate()
    {
        int[] values = new int[3];
        Random generator = new Random();
        values[0] = generator.nextInt(2000) + 1753;
        values[1] = generator.nextInt(12) + 1;
        values[2] = generator.nextInt(27) + 1;

        return values;
    }
}

