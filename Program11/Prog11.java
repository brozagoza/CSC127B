import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/*=======================================================================================================================================
 |   Assignment:  Program #11: Decoding Prefix Codes
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  December 9th, 2015
 |
 |  Description:  This program takes in a file specified by the user contating the PreOrder and InOrder traversels of a
 |                binary tree. This program then buils the tree from these representations in the file. This program then outputs
 |                the PostOrder form of the binary tree. The second task this program does is decode a message from some text
 |                given as '0' and '1's. This program outputs both.
 |                
 | Operational :  Java v6.0
 | Requirements   
 |
 | Deficencies :  none
 |                
 *=====================================================================================================================================*/
class Prog11 
{
    public static void main (String [] args)
    {
        String path = "";                  // path to text file
        String preOrder = "";              // preorder read from file
        String inOrder = "";               // postorder read from file
        String sequence = "";              // encoded sequence of values
        BufferedReader inputFile = null;   // to hold the input file
        Scanner keyboard = new Scanner(System.in);
        
        
        System.out.printf("Whats up brother bear, please enter the file name right here.\n");
        path = keyboard.nextLine(); // takes in the file from the keyboard
        
        
        
        try
        {
            inputFile = new BufferedReader(new FileReader(path));
            preOrder = inputFile.readLine();
            inOrder = inputFile.readLine();
            sequence = inputFile.readLine();
        }catch (FileNotFoundException e)
        {
            System.out.println("File was not found, please make sure you typed it correctly.");
            return;
        }
        catch (IOException e)
        {
            System.out.println("IOException. Welp.");
            return;
        }
        
        System.out.println();
        
        BinaryNode<Integer> root = constructTree (makeArray(preOrder), makeArray(inOrder)); // will return the root node of the tree
        
        
        System.out.printf("Post-Order Transversal: ");
        root.printPostOrder();
        System.out.printf("\n");
        
        
        System.out.printf("Decoded Sequence: ");
        decode(root, sequence);
        System.out.printf("\n");
        
        
        
    } // end main
    
    /*===================================================================================================================================
     |  Method makeArray
     |
     |        Purpose: Creates an ArrayList from the string that is being passed in.
     |
     |     Parameters: String str - string to make an array from
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Creates a new ArrayList.
     |
     |        Returns:  ArrayList list
     *=================================================================================================================================*/
    public static ArrayList<Integer> makeArray (String str)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scan = new Scanner(str);
        
        while (scan.hasNextInt())
            list.add( scan.nextInt() );
        
        
        return list;
    } // end makeArray
    
    /*===================================================================================================================================
     |  Method printArray
     |
     |        Purpose: Prints the ArrayList 
     |
     |     Parameters: int size - the size of the queue
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Creates a new queue.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public static void printArray (ArrayList<Integer> in)
    {
        //int d = in.get(2);
        for (int i = 0; i < in.size(); i++)
            System.out.printf("%d ", in.get(i));
        
        System.out.printf("\n");
    } // end printArray
    
    
    /*===================================================================================================================================
     |  Method splitArray
     |
     |        Purpose: Returns a shortned version fo the Arraylist being passed in from the index's specified.
     |
     |     Parameters: ArrayList<Integer> in - the array list to be split up
     |                 int start - the starting point
     |                 int end - the ending point
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Splits up the array into a smaller array.
     |
     |        Returns:  ArrayList<Integer> newArray
     *=================================================================================================================================*/
    public static ArrayList<Integer> splitArray (ArrayList<Integer> in, int start, int end)
    {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        
        for (int i = start; i < end; i++)
        {
            newArray.add( in.get(i) );
        } // end for loop
        
        return newArray;
    }
    
    
    
    /*===================================================================================================================================
     |  Method constructTree
     |
     |        Purpose: Creates the binary tree from the given pre order and in order listings passed in. Returns the root node
     |                 of the binary tree. Uses recursion because recursion is beautiful.
     |
     |     Parameters: ArrayList<Integer> preOrder - the tree in pre order
     |                 ArrayList<Integer> inOrder - the tree in order
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Creates the binary tree and returns the root of the tree
     |
     |        Returns:  BinaryNode<Integer> root - the root of the tree
     *=================================================================================================================================*/
    public static BinaryNode<Integer> constructTree (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder)
    {
        
        if (inOrder.size() == 0)
            return null;         // GET OUT OF HERE THERES NOTHING ELSE TO DO DAWG COME ON MAN
        
        int current = preOrder.get(0);                                      // holds the current node as top dog
        BinaryNode<Integer> currentNode = new BinaryNode<Integer>(current); // creates the new top dawg as a node
        
        preOrder.remove(0); // gets rid of the current value being looked at
        
        ArrayList<Integer> inOrderLeft = splitArray (inOrder, 0, inOrder.indexOf(current) ); // all values left of the curent
        ArrayList<Integer> inOrderRight = splitArray (inOrder, inOrder.indexOf(current) + 1, inOrder.size()); // all values right of current
        
        
        currentNode.setLeft (constructTree (preOrder, inOrderLeft ));    // Do the Left Part
        currentNode.setRight (constructTree (preOrder, inOrderRight ));  // Do the Right part
        
        
        return currentNode;
    } // end constructTree
    
    
    
    /*===================================================================================================================================
     |  Method decode
     |
     |        Purpose: Decodes the secret number message from the given secret binary numbers from the text file wow super secret.
     |
     |     Parameters: BinaryNode<Integer> root - the root of the binary tree
     |                 String sequence - the sequence as a string object
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Prints out the decoded message
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public static void decode (BinaryNode<Integer> root, String sequence)
    {
        BinaryNode<Integer> temp = root;
        
        for (int i = 0; i < sequence.length(); i++)
        {
            if (temp.getLeft() == null && temp.getRight() == null)
            {
                System.out.printf("%d", temp.getData());
                temp = root;
                i--; 
            } // end if
            
            else if (sequence.charAt(i) == '0')
                temp = temp.getLeft();
            
            else if (sequence.charAt(i) == '1')
                temp = temp.getRight();
            
        } // end for loop
        
        
        // Prints the last part of the tree since the loop cant do it
        if (temp.getLeft() == null && temp.getRight() == null)
        {
            System.out.printf("%d\n", temp.getData());
            temp = root;
            
        }
    } // end decode
    
} // end class




/*=================================================================================================================================*
 ||
 ||  Class BinaryNode<E> 
 ||
 ||         Author:  Alejandro Zaragoza
 ||
 ||        Purpose:  This class represents a node of a BinaryTree containing whatever data the user wants it to be using
 ||                  generics.
 ||
 ||  Inherits From:  None
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  BinaryNode (E dataIn)
 ||
 ||  Class Methods:  None
 ||
 ||  Inst. Methods:  printPostOrder()
 ||                  setData()
 ||                  getData()
 ||                  getRight()
 ||                  getLeft()
 ||                  getData()
 ||
 =================================================================================================================================*/
class BinaryNode< E >
{
    private E data;                   // contains the data of this node
    private BinaryNode<E> leftChild;  // left child
    private BinaryNode<E> rightChild; // right child
    private BinaryNode<E> parent;     // holds the daddy
    
    
    /*===================================================================================================================================
     |  Constructor BinaryNode
     |
     |        Purpose: Creates a new BinaryNode object.
     |
     |     Parameters: E dataIn - the data the node is to contain
     |
     |    Pre-Condition: (none)
     |   Post-Condition: A BinaryNode object has been created woot woot.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public BinaryNode (E dataIn)
    {
        data = dataIn;
        leftChild = null;
        rightChild = null;
    } // end constructor
    
    
    
    /*===================================================================================================================================
     |  Method printPostOrder
     |
     |        Purpose: Prints the post order traversal starting from this node.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Prints out the traversal
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void printPostOrder ()
    {
        if (leftChild != null)
            leftChild.printPostOrder(); // Print all of the left node tree
        
        if (rightChild != null)
            rightChild.printPostOrder(); // Print all of the right node tree
        
        System.out.print(data+" "); // print this data
    } // end printPostorder
    
    
    
    
    /*===================================================================================================================================
     |  Method setData
     |
     |        Purpose: Sets the data from the data that is passed in.
     |
     |     Parameters: E dataIn - the data being passed in
     |
     |    Pre-Condition: (none)
     |   Post-Condition: Updates the data of this node.
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void setData (E dataIn)
    {
        data = dataIn;
    } // end setData
    
    
    /*===================================================================================================================================
     |  Method setLeft
     |
     |        Purpose: Sets this node's left child to the node being passed in.
     |
     |     Parameters: BinaryNode<E> left - left child
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void setLeft (BinaryNode<E> left)
    {
        leftChild = left;
    } // end setLeft
    
    
    /*===================================================================================================================================
     |  Method setRight
     |
     |        Purpose: Sets this node's right child to the node being passed in.
     |
     |     Parameters: BinaryNode<E> right - right child
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void setRight (BinaryNode<E> right)
    {
        rightChild = right;
    } // end setRight
    
    
    /*===================================================================================================================================
     |  Method getData
     |
     |        Purpose: Return's this node's data.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public E getData ()
    {
        return data;
    } // returns the data
    
    
    /*===================================================================================================================================
     |  Method getLeft
     |
     |        Purpose: Return's this node's left child.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public BinaryNode<E> getLeft ()
    {
        return leftChild;
    } // end getLeft
    
    
    /*===================================================================================================================================
     |  Method getRight
     |
     |        Purpose: Return's this node's right child.
     |
     |     Parameters: (none)
     |
     |    Pre-Condition: (none)
     |   Post-Condition: (none)
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public BinaryNode<E> getRight ()
    {
        return rightChild;
    } // end getRight
    
    
} // end class