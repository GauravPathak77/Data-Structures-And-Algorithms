import java.util.*;

public class MirroraBST {
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

    // Create Mirror BST
    public static Node createMirror(Node root){
        if(root == null){
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
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
            preorder(root);
            System.out.println("\nAfter creating mirror image of BST: ");
            root = createMirror(root);
            preorder(root);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}