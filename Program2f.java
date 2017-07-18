import java.util.Random;
import java.nio.BufferOverflowException;

public class Program2
{
    public static void main(String[] args)
    {
        int correct = 0;
        final int TOTAL = 13;
        
        System.out.println("Failed the following test cases:\n");
        
        //Test 1: testing the default constructor 
        BinaryNumber defaultBin = new BinaryNumber();
        if(defaultBin.toString().equals("00000000"))
            correct += 1;
        else
            System.out.println("Failed Test 1\n");
        
        //Test 2: testing the user input constructor with 4 bits
        BinaryNumber userInput = new BinaryNumber("0011");
        if(userInput.toString().equals("0011"))
            correct += 1;
        else
            System.out.println("Failed Test 2\n");
        
        //Test 3: testing to see if constructor throws an exception for non binary digits
        while(true)
        {
            try
            {
                BinaryNumber userInput2 = new BinaryNumber("1234");
            }
            catch(IllegalArgumentException e)
            {
                correct += 1;
                break;
            }
            System.out.println("Failed Test 3\n");
            break;
        }
        
        
        //Test 4: testing the user input constructor with less than 4 bits
        BinaryNumber userInput3 = new BinaryNumber("11");
        if(userInput3.toString().equals("0011"))
            correct += 1;
        else
            System.out.println("Failed Test 4\n");
        
        //Test 5: testing to see if setValue changes the value
        BinaryNumber setValue = new BinaryNumber("0000");
        setValue.setValue("0111");
        if(setValue.toString().equals("0111"))
            correct += 1;
        else
            System.out.println("Failed Test 5\n");
        
        //Test 6: testing to see if setValue throws an exception for an input too large
        while(true)
        {    
            try
            {
                setValue.setValue("001101");
            }
            catch(IllegalArgumentException e)
            {
                correct += 1;
                break;
            }
            System.out.println("Failed Test 6\n");
            break;
        }
        
        //Test 7: testing to see if equal method works
        BinaryNumber eq1 = new BinaryNumber("0101");
        BinaryNumber eq2 = new BinaryNumber("0101");
        if(eq1.equal(eq2))
            correct += 1;
        else
            System.out.println("Failed Test 7\n");
        
        //Test 8: testing to see if incrementBy method works
        BinaryNumber incBy1 = new BinaryNumber("0011");
        BinaryNumber incBy2 = new BinaryNumber("0001");
        incBy1.incrementBy(incBy2);
        if(incBy1.toString().equals("0100"))
            correct += 1;
        else
            System.out.println("Failed Test 8\n");
        
         /*Test 9: testing to see if incrementBy throws exception for adding a
         *        BinaryNumber with too many bits
         */
        BinaryNumber tooBig = new BinaryNumber("10101010");
        while(true)
        {
            try
            {
                incBy1.incrementBy(tooBig);
            }
            catch(BufferOverflowException e)
            {
                correct += 1;
                break;
            }
            System.out.println("Failed Test 9\n");
            break;
        }
        
         /*Test 10: testing to see if incrementBy throws an exception for 
         *          two positives converting into a negative
         */
        BinaryNumber pos1 = new BinaryNumber("0100");
        BinaryNumber pos2 = new BinaryNumber("0100");
        while(true)
        {
            try
            {
                pos1.incrementBy(pos2);
            }
            catch(ArithmeticException e)
            {
                correct += 1;
                break;
            }
            System.out.println("Failed Test 10\n");
            break;
        }
        
        //Test 11: testing to see if decrementBy method works
        BinaryNumber decBy1 = new BinaryNumber("0011");
        BinaryNumber decBy2 = new BinaryNumber("0001");
        decBy1.decrementBy(decBy2);
        if(decBy1.toString().equals("0010"))
            correct += 1;
        else
            System.out.println("Failed Test 11\n");
        
         /*Test 12: testing to see if decrementBy throws exception for 
         *          subtracting a BinaryNumber with too many bits
         */
        while(true)
        {
            try
            {
                decBy1.decrementBy(tooBig);
            }
            catch(BufferOverflowException e)
            {
                correct += 1;
                break;
            }
            System.out.println("Failed Test 12\n");
            break;
        }
        
         /*Test 13: testing to see if incrementBy throws an exception for 
         *          two positives converting into a negative
         */
        BinaryNumber pos3 = new BinaryNumber("0100");
        BinaryNumber pos4 = new BinaryNumber("1011");
        while(true)
        {
            try
            {
                pos3.decrementBy(pos4);
            }
            catch(ArithmeticException e)
            {
                correct += 1;
                break;
            }
            System.out.println("Failed Test 13\n");
            break;
        }
        
        
        /*int points = 1;
        for( int i = 0; i < 100 && points > 0; i++)
        {
            String binNum = new String(randomBin());
            BinaryNumber temp = 
                new BinaryNumber(binNum);
            
            if( !temp.toString().equals(binNum))
            {
                points--;
                System.out.printf("Test failed on constructor input: %s\n", binNum);
            }
            
            binNum = randomBin();
            
            temp.setValue(binNum);
            
            if( !temp.toString().equals(binNum) )
            {
                points--;
                System.out.printf("Test failed on setValue input: %s/n",binNum);
            }
        } 
        correct += points;
        
        /*public String randomBin()
        {
            Random generator = new Random();
            int[] values = new int[generator.nextInt(50)];
            String temp = new String("");
            for(int i = 0; i < values.length; i++)
            {
                values[i] = generator.nextInt(36) % 2;
                temp = values[i] + temp;
            }
            
            return temp;
        }
        */
        
        
        
        System.out.printf("Final Score: %d out of %d\n", correct, TOTAL);
    }
}