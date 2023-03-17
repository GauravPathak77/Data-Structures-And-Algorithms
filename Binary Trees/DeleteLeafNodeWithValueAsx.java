import java.util.*;
public class DeleteLeafNodeWithValueAsx {
    static class Node{
        int data;
        Node left; 
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;
        public Node buildTree(ArrayList<Integer> nodes){
            idx++;
            if(nodes.get(idx) == -1){
                return null;
            }

            Node newNode = new Node(nodes.get(idx));
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Preorder Traversal
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Delete Node with value as x
    public static Node deleteNode(Node root, int x){
        if (root == null)
            return null;
        root.left = deleteNode(root.left, x);
        root.right = deleteNode(root.right, x);
        if (root.data == x && root.left == null && root.right == null) {
            return null;
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
            System.out.print("\nDo you Want to Delete leaf nodes of tree having any specific value(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                System.out.print("Enter the value of nodes: ");
                int x = sc.nextInt();
                deleteNode(root, x);
                System.out.print("New tree is: ");
                preorder(root);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
