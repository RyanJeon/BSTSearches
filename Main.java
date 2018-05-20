
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int val;

    Node right; //right node
    Node left;  //left node

    public Node(int value){
        val = value;
    }
    
}


public class Main{

    //store shit
    public static void insertion(Node root, int number){
        Node temp = new Node(number); //will added on to the tree
        if(root.val >= number) root.left = temp;
        else root.right = temp;       
    }

    //Let's do it preorder? root -> left -> right
    public static void DFS(Node root){
        if(root == null ) return;

        System.out.println(root.val);
        DFS(root.left); //left
        DFS(root.right); //right   
    }

    //Let's implement BFS ;) :) :)
    public static void BFS(Node root){
        Queue<Node> q = new LinkedList<>(); //init queue
        
        q.add(root); //add root node to the queue

        //while the queue is not empty 
        while(!q.isEmpty()){
            Node c = q.remove(); //gives the first added

            System.out.println(c.val); //print the current value

            if(c.left != null) q.add(c.left);
            if(c.right != null) q.add(c.right);

        }

        
    }

    //This function will construct binary search tree given an odd number sorted list
    public static Node MakeTree(int[] arr, int start, int end){
        
        if(start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        node.left = MakeTree(arr, start, mid-1);
        node.right = MakeTree(arr, mid+1, end);

        return node;

    }


    public static void main(String[] args){
        


        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int n = reader.nextInt(); //Length of the array
        
        int[] nums = new int[n]; //allocate memory for the number integers
        
        System.out.println("Enter your numbers: ");
        for(int i = 0; i < n; i++){
            int num = reader.nextInt();
            nums[i] = num;
        }


        //finished reading
        reader.close();



        Node root = MakeTree(nums, 0, nums.length-1);

        
        System.out.println("BFS Search Result: ");
        BFS(root);

        System.out.println("DFS Search Result: ");
        DFS(root);








    }

}