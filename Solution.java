class Node
{
    Node left;
    Node right;
}




public class Solution {
    static boolean bal(Node r)
    {
        return (Math.max(deep_depth(r.left),deep_depth(r.right)) - Math.min(deep_depth(r.left),deep_depth(r.right)) <= 1);
    }

static int deep_depth(Node n)
{
    if (n.left == null && n.right == null)
        return 0;
    int l_c = 0, r_c = 0;
    
    if (n.left != null) l_c = 1 + deep_depth(n.left);
    if (n.right != null) r_c = 1 + deep_depth(n.right);
    if (l_c > r_c) return l_c; else return r_c;
}
    
public static int robo_count(int n){
    return true_robo_count(n, 0, 0);
}

private static int true_robo_count(int n, int x, int y)
{
    if (x == n-1 && y == n-1)
        return 1;
    else if (x == n-1 && y != n-1)
        return true_robo_count(n, x, y+1);
    else if (x != n-1 && y == n-1)
        return true_robo_count(n, x+1, y);
    else
        return true_robo_count(n, x+1, y) + true_robo_count(n, x, y+1);
}
    
    public static void main (String [] args) {
//        Node root = new Node();
//        Node l1 = new Node();
//        root.left = l1;
//        Node r1 = new Node();
//        root.right = r1;
//        Node r2 = new Node();
//        r1.right = r2;
//        Node r3 = new Node();
//        r2.right = r3;
//        
//        System.out.println(bal(root));

        System.out.println(robo_count(3));
        
    } // end main
    
}