public class fuckyou{
   
   public static void main (String[]args){
      
      System.out.print("\n**************************TESTING ADDTERM/TOSTRING**************************\n");
      
//TEST 1     //1 term test for addTerm and toString   
      PolynomialA polyTest = new PolynomialA();
      
      polyTest.addTerm(2,4);  
      
      if("(2)x^(4)".compareTo(polyTest.toString())==0)
         System.out.print("Correct Should be: (2)x^(4) || Result: "+polyTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (2)x^(4) || Result: "+polyTest.toString()+"\n");
      
//TEST 2     //2 term test for addTerm and toString
      polyTest.addTerm(5,3);  
      
      if("(2)x^(4) + (5)x^(3)".compareTo(polyTest.toString())==0)
         System.out.print("Correct Should be: (2)x^(4) + (5)x^(3) || Result: "+polyTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (2)x^(4) + (5)x^(3) || Result: "+polyTest.toString()+"\n");
      
//TEST 3    //3 term test for addTerm and toString (decreasing order specifically tested)
      
      polyTest.addTerm(2,7);
      
      if(polyTest.toString().compareTo("(2)x^(7) + (2)x^(4) + (5)x^(3)")==0)
         System.out.print("Correct Should be: (2)x^(7) + (2)x^(4) + (5)x^(3) || Result: "+polyTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (2)x^(7) + (2)x^(4) + (5)x^(3) || Result: "+polyTest.toString()+"\n");
      
//TEST 4 //negative coefficents and exponents and 0 exponent (added in reverse order to test string sorting)
      PolynomialA polyTest1 = new PolynomialA();
      
      polyTest1.addTerm(-2,-4);
      polyTest1.addTerm(3,0);
      polyTest1.addTerm(-3,-2);
      
      if("(3)x^(0) - (3)x^(-2) - (2)x^(-4)".compareTo(polyTest1.toString())==0)
         System.out.print("Correct Should be: (3)x^(0) - (3)x^(-2) - (2)x^(-4) || Result: "+polyTest1.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (3)x^(0) - (3)x^(-2) - (2)x^(-4) || Result: "+polyTest1.toString()+"\n");
//TEST 5 //test addTerm for same exponent, added two terms with the same exponenet for total of 3
      polyTest.addTerm(3,7);
      polyTest.addTerm(2,7);
      if(polyTest.toString().compareTo("(7)x^(7) + (2)x^(4) + (5)x^(3)")==0)
         System.out.print("Correct Should be: (7)x^(7) + (2)x^(4) + (5)x^(3) || Result: "+polyTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (7)x^(7) + (2)x^(4) + (5)x^(3) || Result: "+polyTest.toString()+"\n");
      
      
      System.out.print("\n**************************TESTING HOLDING**************************\n");     
      
//TEST 1 testing polyTest, holding 3 terms all positive exponents and coefficients. 
      if(polyTest.holding()==3)
         System.out.print("Correct Should be: 3 || Result: "+polyTest.holding()+"\n");
      else 
         System.out.print("INCORRECT Should be: 3|| Result: "+polyTest.holding()+"\n");
      
//TEST 2 testing polyTest 1 holding 3 terms some positive some negative. includes negative exponent
      if(polyTest1.holding()==3)
         System.out.print("Correct Should be: 3 || Result: "+polyTest1.holding()+"\n");
      else 
         System.out.print("INCORRECT Should be: 3|| Result: "+polyTest1.holding()+"\n");
      
      System.out.print("\n**************************TESTING ADD**************************\n");  
      
//TEST 1 testing polyTest and polyTest 1 all differnet Exponents
      PolynomialA sumTest = polyTest.add(polyTest1);
      
      if(sumTest.toString().compareTo("(7)x^(7) + (2)x^(4) + (5)x^(3) + (3)x^(0) - (3)x^(-2) - (2)x^(-4)")==0)
         System.out.print("Correct Should be: (7)x^(7) + (2)x^(4) + (5)x^(3) + (3)x^(0) - (3)x^(-2) - (2)x^(-4) || Result: "+sumTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (7)x^(7) + (2)x^(4) + (5)x^(3) + (3)x^(0) - (3)x^(-2) - (2)x^(-4) || Result: "+sumTest.toString()+"\n");
      
//TEST 2 //adding two polynomials, polyTest0 is one term which has the same exponent as polyTests 1st term, so they should combine
      PolynomialA polyTest0 = new PolynomialA();
      polyTest0.addTerm(3,7);
      sumTest = polyTest.add(polyTest0);
      
      if(sumTest.toString().compareTo("(10)x^(7) + (2)x^(4) + (5)x^(3)")==0)
         System.out.print("Correct Should be: (10)x^(7) + (2)x^(4) + (5)x^(3) || Result: "+sumTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (10)x^(7) + (2)x^(4) + (5)x^(3) || Result: "+sumTest.toString()+"\n");
      System.out.print("\n**************************TESTING SCALARMULTIPLY**************************\n");
      
//TEST 1 
      polyTest.scalarMultiply(3);
      if(polyTest.toString().compareTo("(21)x^(7) + (6)x^(4) + (15)x^(3)")==0)
         System.out.print("Correct Should be: (21)x^(7) + (6)x^(4) + (15)x^(3) || Result: "+polyTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (21)x^(7) + (6)x^(4) + (15)x^(3) || Result: "+polyTest.toString()+"\n");
      
//TEST 2
      polyTest1.scalarMultiply(3);
      if(polyTest1.toString().compareTo("(9)x^(0) - (9)x^(-2) - (6)x^(-4)")==0)
         System.out.print("Correct Should be: (9)x^(0) - (9)x^(-2) - (6)x^(-4) || Result: "+polyTest1.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: (9)x^(0) - (9)x^(-2) - (6)x^(-4) || Result: "+polyTest1.toString()+"\n");
      
      System.out.print("\n**************************TESTING ISEMPTY**************************\n");
      
//TEST 1  //Test empty polynomial    
      PolynomialA isEmptyTest = new PolynomialA();
      if(isEmptyTest.isEmpty()==true)
         System.out.print("Correct Should be: true || Result: "+isEmptyTest.isEmpty()+"\n");
      else 
         System.out.print("INCORRECT Should be: true || Result: "+isEmptyTest.isEmpty()+"\n");  
      
//TEST 2 //test polynomial w/ term      
      isEmptyTest.addTerm(1,2);
      if(isEmptyTest.isEmpty()==false)
         System.out.print("Correct Should be: false || Result: "+isEmptyTest.isEmpty()+"\n");
      else 
         System.out.print("INCORRECT Should be: false || Result: "+isEmptyTest.isEmpty()+"\n");
      
      System.out.print("\n**************************TESTING GETCOEFFICIENT**************************\n");
      
//TEST 1 //use polyTest which is (21)x^(7) + (6)x^(4) + (15)x^(3) test for Exponent 4     
      polyTest.getCoefficient(4);
      
      if(polyTest.getCoefficient(4)==6)
         System.out.print("Correct Should be: 6 || Result: "+polyTest.getCoefficient(4)+"\n");
      else 
         System.out.print("INCORRECT Should be: 6 || Result: "+polyTest.getCoefficient(4)+"\n");  
      
//TEST 2 test polyTest with exponent that doesn't exist
      polyTest.getCoefficient(8);
      
      if(polyTest.getCoefficient(8)==0)
         System.out.print("Correct Should be: 0 || Result: "+polyTest.getCoefficient(8)+"\n");
      else 
         System.out.print("INCORRECT Should be: 0 || Result: "+polyTest.getCoefficient(8)+"\n");  
      
      System.out.print("\n**************************TESTING EVALUATE**************************\n");
      
//TEST 1 //polyTest 3 is (1)x^(2)+(1)x^(3) evaluate at x = 2
      
      PolynomialA polyTest3 = new PolynomialA();
      polyTest3.addTerm(1,2);
      polyTest3.addTerm(1,3);
      
      if(polyTest3.evaluate(2)==12.0)
         System.out.print("Correct Should be: 12.0 || Result: "+polyTest3.evaluate(2)+"\n");
      else 
         System.out.print("INCORRECT Should be: 12.0 || Result: "+polyTest3.evaluate(2)+"\n");
      
//TEST 2 testing on polyTest which is (21)x^(7) + (6)x^(4) + (15)x^(3) evaluated at 5 ULTIMATE TEST
      if(polyTest.evaluate(5)==1646250.0)
         System.out.print("Correct Should be: 1646250.0 || Result: "+polyTest.evaluate(5)+"\n");
      else 
         System.out.print("INCORRECT Should be: 1646250.0|| Result: "+polyTest.evaluate(5)+"\n");
      
      System.out.print("\n**************************TESTING NEGATE**************************\n");
      
//TEST 1 //negating polyTest which is  (21)x^(7) + (6)x^(4) + (15)x^(3) 
      PolynomialA negateTest = polyTest.negate();
      if(negateTest.toString().compareTo(" - (21)x^(7) - (6)x^(4) - (15)x^(3)")==0)
         System.out.print("Correct Should be: - (21)x^(7) - (6)x^(4) - (15)x^(3) || Result: "+negateTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: - (21)x^(7) - (6)x^(4) - (15)x^(3) || Result: "+negateTest.toString()+"\n");
      
//TEST 2 //negating polyTest1 which is (9)x^(0) - (9)x^(-2) - (6)x^(-4) some pos some neg
      negateTest = polyTest1.negate();
      if(negateTest.toString().compareTo(" - (9)x^(0) + (9)x^(-2) + (6)x^(-4)")==0)
         System.out.print("Correct Should be:  - (9)x^(0) + (9)x^(-2) + (6)x^(-4) || Result: "+negateTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be:  - (9)x^(0) + (9)x^(-2) + (6)x^(-4) || Result: "+negateTest.toString()+"\n");
      
      System.out.print("\n**************************TESTING EQUALS**************************\n");
      
//TEST 1 an easy test that should be false. polyTest.equals(polyTest1)     
 
      if(polyTest.equals(polyTest1)==false)
         System.out.print("Correct Should be: false || Result: "+polyTest.equals(polyTest1)+"\n");
      else 
         System.out.print("INCORRECT Should be: false || Result: "+polyTest.equals(polyTest1)+"\n");  
      
//TEST 2 test equals w/ polyTest and equalsTest, which are the same (21)x^(7) + (6)x^(4) + (15)x^(3)   
      PolynomialA equalsTest = new PolynomialA();
      equalsTest.addTerm(21,7);
      equalsTest.addTerm(6,4);
      equalsTest.addTerm(15,3);
      
      if(polyTest.equals(equalsTest)==true)
         System.out.print("Correct Should be: true || Result: "+polyTest.equals(equalsTest)+"\n");
      else 
         System.out.print("INCORRECT Should be: true || Result: "+polyTest.equals(equalsTest)+"\n");
            
     
   System.out.print("\n**************************TESTING REPLICATE**************************\n");
//TEST 1 //replicating polyTest which is  (21)x^(7) + (6)x^(4) + (15)x^(3) 
   
      PolynomialA replicateTest= polyTest.replicate();
      if(replicateTest.toString().compareTo(polyTest.toString())==0)
         System.out.print("Correct Should be: "+polyTest.toString()+" || Result: "+replicateTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: "+polyTest.toString()+" || Result: "+replicateTest.toString()+"\n");  
      
//TEST 2 //replicating polyTest1 which is  (9)x^(0) - (9)x^(-2) - (6)x^(-4)
      
      replicateTest= polyTest1.replicate();
      if(replicateTest.toString().compareTo(polyTest1.toString())==0)
         System.out.print("Correct Should be: "+polyTest1.toString()+" || Result: "+replicateTest.toString()+"\n");
      else 
         System.out.print("INCORRECT Should be: "+polyTest1.toString()+" || Result: "+replicateTest.toString()+"\n");   
      
   }
}