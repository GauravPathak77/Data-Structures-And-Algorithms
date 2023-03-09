import java.util.*;
public class KthLevelOfATree_Iterative {
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

    // Kth Level of a Tree (Iterative Approach)
    public static void kLevel(Node root, int k) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    System.out.println("Invalid Level");
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if (level == k) {
                while(curr != null){
                    System.out.print(curr.data + " ");
                    curr = q.remove();
                }
                break;
            }

            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
            level++;
            }
        }
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
            System.out.print("\nDo you Want to print any level of tree(y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Enter the value of level which you want to print: ");
            int k = sc.nextInt();
            if (ch == 'y' || ch == 'Y') {
                kLevel(root, k);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
