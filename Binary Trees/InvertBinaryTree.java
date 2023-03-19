import java.util.*;
public class InvertBinaryTree {
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

    // Level Order Traversal
    public static void levelorder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static Node invertBinaryTree(Node root){
        if(root == null){
            return null;
        }

        BinaryTree tree = new BinaryTree();
        InvertBinaryTree.BinaryTree.idx = -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.data);
        list.add(-1);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
                list.add(-1);
            } else {
                if (currNode.right != null) {
                    q.add(currNode.right);
                    list.add(currNode.right.data);
                }
                 if (currNode.left != null) {
                    q.add(currNode.left);
                    list.add(currNode.left.data);
                }
            }
        }

        Node newRoot = tree.buildTree(list);
        return newRoot;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Integer> nodes = new ArrayList<>();
            System.out.println("Enter values of nodes: ");
            char choice;
            do {
                int data = sc.nextInt();
                nodes.add(data);
                System.out.print("Do you Want to enter more values(y/n)? ");
                choice = sc.next().charAt(0);
            } while (choice == 'y' || choice == 'Y');

            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.print("\nDo you Want to print Invert of tree(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                System.out.println("Original Tree is: ");
                levelorder(root);
                Node newRoot = invertBinaryTree(root);
                System.out.println("Invert Tree is: ");
                levelorder(newRoot);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
