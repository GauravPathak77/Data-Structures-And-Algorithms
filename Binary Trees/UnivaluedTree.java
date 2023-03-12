import java.util.*;
public class UnivaluedTree {
    static class Node {
        int data;
        Node left, right;

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

    public static boolean isUnivalTree(Node root) {
        if (root == null) {
            return false;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int val = root.data;
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
             if (currNode == null) {
                 if (q.isEmpty()) {
                     break;
                 } else {
                     q.add(null);
                 }
             } else {
                 if(currNode.data != val) {
                     return false;
                 }
                 if (currNode.left != null) {
                     q.add(currNode.left);
                 }
                 if (currNode.right != null) {
                     q.add(currNode.right);
                 }
             }
        }
        return true;
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
            System.out.print("\nDo you Want to check tree is univalued or not(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                if (isUnivalTree(root)) {
                    System.out.print("YES");
                } else {
                    System.out.print("NO");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
