import java.util.*;
public class TopViewOfATree {
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
    static class Info{
        Node node;
        int hd;

        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        // Level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                    q.add(null);
            }
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for(int i = min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
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
            System.out.print("\nDo you Want to print Top View of tree(y/n)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                topView(root);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
