import java.util.*;
public class LowestCommonAncestor2 {
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

    // Lowest Common Ancestor
    public static Node lca(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if(rightLca == null){
            return leftLca;
        }
        if(leftLca == null){
            return rightLca;
        }

        return root;
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
            System.out.print("\nDo you Want to print lowest common ancestor of two nodes of tree(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                System.out.print("\nEnter first node: ");
                int n1 = sc.nextInt();
                System.out.print("Enter second node: ");
                int n2 = sc.nextInt();
                Node Lca = lca(root, n1, n2);
                System.out.println("Lowest common ancestor is: " + Lca);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
