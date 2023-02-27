import java.util.*;
public class BuildTreePreorder{
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
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            ArrayList<Integer> nodes = new ArrayList<>();
            System.out.println("Enter values of nodes and -1 for null: ");
            char choice;
            do{
                int data = sc.nextInt();
                nodes.add(data);
                System.out.print("Do you Want to enter more values(y/n)? ");
                choice = sc.next().charAt(0);
            }while(choice == 'y' || choice == 'Y');

            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.println("Value of root is" + root.data);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}