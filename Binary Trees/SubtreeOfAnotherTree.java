import java.util.*;
public class SubtreeOfAnotherTree {
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

    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }

        if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {

            // Input Root
            ArrayList<Integer> nodes = new ArrayList<>();
            System.out.println("Enter nodes of Tree and -1 for null node: ");
            char choice;
            do {
                int data = sc.nextInt();
                nodes.add(data);
                System.out.print("Do you Want to enter more values(y/n)? ");
                choice = sc.next().charAt(0);
            } while (choice == 'y' || choice == 'Y');
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);

            SubtreeOfAnotherTree.BinaryTree.idx = -1;
            // Input Subroot
            ArrayList<Integer> subRoot_nodes = new ArrayList<>();
            System.out.println("\nEnter nodes of SubTree and -1 for null node: ");
            choice = 'n';
            do {
                int data = sc.nextInt();
                subRoot_nodes.add(data);
                System.out.print("Do you Want to enter more values(y/n)? ");
                choice = sc.next().charAt(0);
            } while (choice == 'y' || choice == 'Y');
            Node subRoot = tree.buildTree(subRoot_nodes);
            System.out.println("\nWant to check SubTree is present in Tree(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                if(isSubtree(root, subRoot)){
                    System.out.println("SubTree is present in given Tree");
                }
                else{
                    System.out.println("SubTree is not present in given Tree");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
