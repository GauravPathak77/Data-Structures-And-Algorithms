import java.util.*;

public class DeleteANode {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Delete A Node
    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        }

        else {

            // leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Single Child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Both Children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    // Find Inorder Successor
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Integer> values = new ArrayList<>();
            char ch;
            do {
                System.out.print("Enter value: ");
                int data = sc.nextInt();
                values.add(data);
                System.out.print("Want to enter more values(y/n)? ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            Node root = null;
            System.out.println("\nBinary Search Tree is: ");
            for (int i = 0; i < values.size(); i++) {
                root = insert(root, values.get(i));
            }
            inorder(root);
            System.out.print("\nEnter the value that you want to delete: ");
            int val = sc.nextInt();
            delete(root, val);
            System.out.println("After deleting the value BST is: ");
            inorder(root);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
