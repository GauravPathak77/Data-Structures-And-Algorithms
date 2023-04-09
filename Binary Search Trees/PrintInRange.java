import java.util.*;

public class PrintInRange {
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

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Print In Range
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
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
            System.out.print("Enter the lower limit of range: ");
            int k1 = sc.nextInt();
            System.out.print("Enter the uper limit of range: ");
            int k2 = sc.nextInt();
            System.out.println("\nElements in given range are: ");
            printInRange(root, k1, k2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
