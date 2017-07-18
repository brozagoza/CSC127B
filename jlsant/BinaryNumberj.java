/*=============================================================================
 |   Assignment:  Program #2: Two's Complement
 |       Author:  Jose Santana (jlsant@email.arizona.edu)
 |       Grader:  Ben Gaska
 |
 |       Course:  CSC 127B
 |   Instructor:  L. McCann
 |     Due Date:  September 10, 2015 9:00 at the beginning of class
 |
 |  Description:  The program is a class that creates BinaryNumber objects.
 |                These objects hold the value of integers in two's complement
 |                form with at least four bits.
 |                
 | Deficiencies:  None
 *===========================================================================*/
import java.nio.BufferOverflowException;


public class BinaryNumberj
{
    String value = new String("");
    
    public BinaryNumberj()
    {
        value = "00000000";
    }
    
    public BinaryNumberj(String input)
    {
        int i = 0;
        
        while(i < input.length())
        {
            if(input.charAt(i) > (1 + 48))
                throw new IllegalArgumentException();
            i++;
        }   
        value = input;
            
        while(value.length() < 4)
        {
            value = "0" + value;
        }
    }
    
    public void setValue(String input)
    {
        int i = 0;
        
        if(input.length() > value.length())
            throw new IllegalArgumentException();
        
        while(i < input.length())
        {
            if(input.charAt(i) > (1 + 48))
                throw new IllegalArgumentException();
            i++;
        }
        i = 0;
        
        while((input.length() + i) < value.length())
        {
            input = "0" + input;
            i++;
        }
        
        value = input;
    }
    
    public String toString()
    {
        return value;
    }
    
    public boolean equal(BinaryNumber input)
    {
        int i = 0;
        int j = 0;
        
        while(input.value.charAt(i) != '0')
        {
            i++;
        }
        while(value.charAt(j) != '0')
        {
            j++;
        }
        
        if((input.value.length() - i) == (value.length() - j))
        {
            while(i < input.value.length())
            {
                if(input.value.charAt(i) != value.charAt(j))
                    return false;
                i++;
                j++;
            }
            return true;
        }
        
        return false;
    }
    
    //increment
    public void incrementBy(BinaryNumber input)
    {
        int i = 0;
        
        if(input.value.length() > value.length())
        {
            throw new BufferOverflowException();
        }
        
        while(input.value.length() < value.length())
        {
            input.value = "0" + input.value;
        }
        
        String bin = new String("");
        char[] temp = new char[value.length()];
        
        if((input.value.charAt(i) == '0') && (value.charAt(i) == '0'))
        {
            while(i < value.length())
            {
                if(value.charAt(value.length()-1-i) == '1' && input.value.charAt(value.length()-1-i) == '1')
                    temp[value.length()-1-i] = '2';
                if(value.charAt(value.length()-1-i) == '1' && input.value.charAt(value.length()-1-i) == '0')
                    temp[value.length()-1-i] = '1';
                if(value.charAt(value.length()-1-i) == '0' && input.value.charAt(value.length()-1-i) == '1')
                    temp[value.length()-1-i] = '1';
                if(value.charAt(value.length()-1-i) == '0' && input.value.charAt(value.length()-1-i) == '0')
                    temp[value.length()-1-i] = '0';
                
                i++;
            }
            i = 0;
            
            while(i < value.length())
            {
                if(temp[value.length()-1-i] == '3')
                {
                    temp[value.length()-1-i] = '1';
                    temp[value.length()-1-1-i] = (char)(temp[value.length()-1-1-i] + 1);
                }
                if(temp[value.length()-1-i] == '2')
                {
                    temp[value.length()-1-i] = '0';
                    temp[value.length()-1-1-i] = (char)(temp[value.length()-1-1-i] + 1);
                }
                i++;
            }
            
            if(temp[0] == '1')
                throw new ArithmeticException();
            
            for(int j = 0; j < value.length();j++)
            {
                bin = bin + temp[j];
            }
            value = bin;
        }
        else
        {
            while(i < value.length())
            {
                if(value.charAt(value.length()-1-i) == '1' && input.value.charAt(value.length()-1-i) == '1')
                    temp[value.length()-1-i] = '2';
                if(value.charAt(value.length()-1-i) == '1' && input.value.charAt(value.length()-1-i) == '0')
                    temp[value.length()-1-i] = '1';
                if(value.charAt(value.length()-1-i) == '0' && input.value.charAt(value.length()-1-i) == '1')
                    temp[value.length()-1-i] = '1';
                if(value.charAt(value.length()-1-i) == '0' && input.value.charAt(value.length()-1-i) == '0')
                    temp[value.length()-1-i] = '0';
                
                i++;
            }
            i = 0;
            
            while(i < value.length()) // to cut off the end of that shit
            {
                if(value.length()-1-i == 0)
                {
                    if(temp[value.length()-1-i] == '3')
                    {
                        temp[value.length()-1-i] = '1';
                    }
                    if(temp[value.length()-1-i] == '2')
                    {
                        temp[value.length()-1-i] = '0';
                    }
                }
                else
                {
                    if(temp[value.length()-1-i] == '3')
                    {
                        temp[value.length()-1-i] = '1';
                        temp[value.length()-1-1-i] = (char)(temp[value.length()-1-1-i] + 1);
                    }
                    if(temp[value.length()-1-i] == '2')
                    {
                        temp[value.length()-1-i] = '0';
                        temp[value.length()-1-1-i] = (char)(temp[value.length()-1-1-i] + 1);
                    }
                }
                i++;
            }
            
            
            for(int j = 0; j < value.length();j++)
            {
                bin = bin + temp[j];
            }
            value = bin;
        }
    }
    
    //decrement
    public void decrementBy(BinaryNumber input)
    {
        int i = 0;
        
        if(input.value.length() > value.length())
        {
            throw new BufferOverflowException();
        }
        
        
        while(input.value.length() < value.length())
        {
            input.value = "0" + input.value;
        }
        
        
        char[] temp = new char[value.length()];
        
        
        i = 0;
        while(i < input.value.length())
        {
            if(input.value.charAt(i) == '0')
                temp[i] = '1';
            else if(input.value.charAt(i) == '1')
                temp[i] = '0';
            i++;
        }
        
        i = 0;
        
        temp[input.value.length()-1] = (char)(temp[input.value.length()-1]+1);
        
        while(temp[value.length() - 1 -i] == '2')
        {
            if(value.length() - 1 -i == 0)
            {
                if(temp[value.length() - 1 -i] == '2')
                    temp[value.length() - 1-i] = '0';
                break;
            }
            temp[value.length() - 1 -i] = (char)(temp[value.length() - 1 -i] - 2);
            temp[value.length() - 1 - 1 -i] = (char)(temp[value.length() -1 - 1 -i] + 1);
            i++;
        }
        i = input.value.length() - 1;
        BinaryNumber valueCopy = new BinaryNumber();
        valueCopy.value = value;
        input.value = "";
        
        while(i >= 0)
        {
            input.value = temp[i] + input.value;
            i--;
        }
        
        input.incrementBy(valueCopy);
        
        value = input.value;
    }
    
}