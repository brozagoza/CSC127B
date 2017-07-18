/* T02n01.java -- Shows how to catch and display information about Java
 * exceptions.  
 *
 * As you've already seen, Java will happily display the name and location
 * of your program's exceptions when something goes wrong.  If you know
 * that there's a chance that your program could fail due to a problem
 * outside of your control, you should use try/catch to detect the exception
 * yourself (rather than having Java detect it for you) and print more
 * detailed error information.
 *
 * Please note that I am using ArrayIndexOutOfBoundsException as the example
 * only because it's a common error familiar to all students.  Using
 * try/catch to handle this sort of error is usually bad form -- you are
 * in complete control of the cause of this sort of error, and so 
 * your code should be written to make sure it doesn't go running off
 * the end of the array in the first place.  When we talk about files, 
 * we'll see IOExceptions, which are more appropriately handled with
 * try/catch because they are 'checked' exceptions.
 */

public class T02n01
{
    public static void main (String [] args)
    {
        short[] smallOdds = {1,3,5,7,9};  // the five smallest positive odds
        int i=0;    // be sure you understand why this is declared here!

        try {

            for (i=0; i<=smallOdds.length; i++)   // a classic off-by-one error
                System.out.print(smallOdds[i] + " ");
            System.out.println();

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("\nOops! The program caused this error:");
            System.out.println("\n\t" + e.getClass().getName());
            System.out.println("\nwhen printing the content of the smallOdds "
                             + "array.\nAt the time of the error, the "
                             + "index into smallOdds was " + i + ".");

            String mesg = e.getMessage();
            if (mesg == null) {
                System.out.println("\nThe exception didn't provide a message.");
            } else {
                System.out.println("\nThe exception's message is:\n\t" + mesg);
            }

            System.out.println("\nThe stack trace is: \n\t");
            e.printStackTrace();

        }
    }
}