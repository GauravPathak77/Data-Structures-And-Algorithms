import java.util.*;
public class LowestCommonAncestor {
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
    
    // Path for lowest common ancestor
    public static boolean getpath(Node root, ArrayList<Node> path, int n) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getpath(root.left, path, n);
        boolean foundRight = getpath(root.right, path, n);

        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    // Lowest Common Ancestor
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root, path1, n1);
        getpath(root, path2, n1);

        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }

        return path1.get(i - 1);
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
            System.out.print("\nDo you Want to print last common ancestor of two nodes of tree(y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Enter the value of level which you want to print: ");
            int k = sc.nextInt();
            if (ch == 'y' || ch == 'Y') {
                System.out.print("\n Enter first node: ");
                int n1 = sc.nextInt();
                System.out.print("\n Enter second node: ");
                int n2 = sc.nextInt();
                Node Lca = lca(root, n1, n2);
                System.out.println("Last common ancestor is: " + Lca);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
