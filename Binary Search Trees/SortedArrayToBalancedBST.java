import java.util.*;

public class SortedArrayToBalancedBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // Create Balanced BST from sorted array
    public static Node createBST(ArrayList<Integer> arr, int st, int ei){
        if(st > ei){
            return null;
        }

        int mid = (st + ei)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, ei);

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
                System.out.print("Enter value in sorted way: ");
                int data = sc.nextInt();
                values.add(data);
                System.out.print("Want to enter more values(y/n)? ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            Node root = createBST(values, 0, values.size()-1);
            System.out.println("\nBalanced BST is: ");
            preorder(root);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
