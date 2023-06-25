import java.util.*;
public class ConvertBSTtoBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    // Preorder
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //get inorder ArrayList
    public static void getInorder(ArrayList<Integer> inorder, Node root){
        if(root == null){
            return;
        }
        inorder.add(root.data);
        getInorder(inorder, root.left);
        getInorder(inorder, root.right);
    }
    // Create BST from ArrayList
    public static Node createBST(ArrayList<Integer> inorder, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }
    // Convert BST to balanced BST
    public static Node balanceBST(Node root){
        // inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(inorder, root);

        // Create BST from inorder
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }
    
}
