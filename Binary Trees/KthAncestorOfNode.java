import java.util.*;
public class KthAncestorOfNode {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public Node buildTree(ArrayList<Integer> nodes) {
            idx++;
            if (nodes.get(idx) == -1) {
                return null;
            }
            Node newNode = new Node(nodes.get(idx));
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Kth Ancestor of Node
    public static int kthAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if(max + 1 == k){
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Integer> nodes = new ArrayList<>();
            System.out.println("Enter values of nodes and -1 for null: ");
            char choice;
            do {
                int data = sc.nextInt();
                nodes.add(data);
                System.out.print("Do you Want to enter more values(y/n)? ");
                choice = sc.next().charAt(0);
            } while (choice == 'y' || choice == 'Y');
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.println("\nDo you Want to find kth ancestor of any node of tree(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                System.out.println("Enter value of node: ");
                int n = sc.nextInt();
                System.out.print("Enter value of k: ");
                int k = sc.nextInt();
                System.out.println("kth ancestor is " + kthAncestor(root, n, k));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
