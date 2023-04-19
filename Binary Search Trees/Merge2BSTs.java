import java.util.*;
public class Merge2BSTs{
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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Get Inorder Sequence
    public static void getInorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // Create BST through Sorted Array
    public static Node createBST(ArrayList<Integer> arr, int st, int end){
        if(st > end){
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, 0, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2){
        // step-1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        // step-2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        // merge BSTs
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i <= arr1.size() && j<= arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }
            if (arr2.get(j) <= arr1.get(i)) {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i <= arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j <= arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        Node root = createBST(finalArr, 0, finalArr.size());
        return root;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Integer> tree1 = new ArrayList<>();
            ArrayList<Integer> tree2 = new ArrayList<>();
            char ch;
            System.out.print("Enter values in first tree: ");
            do {
                int data = sc.nextInt();
                tree1.add(data);
                System.out.print("Do you want to enter more values(y/n)? ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            Node root1 = null;
            System.out.println("\nFirst Binary Search Tree is: ");
            for (int i = 0; i < tree1.size(); i++) {
                root1 = insert(root1, tree1.get(i));
            }
            inorder(root1);
            System.out.print("\nEnter values in second tree: ");
            do {
                int data = sc.nextInt();
                tree2.add(data);
                System.out.print("Do you want to enter more values(y/n)? ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            Node root2 = null;
            System.out.println("\nSecond Binary Search Tree is: ");
            for (int i = 0; i < tree2.size(); i++) {
                root2 = insert(root2, tree2.get(i));
            }
            inorder(root2);
            System.out.println("\nAfter merging both trees: ");
            Node root3 = mergeBSTs(root1, root2);
            inorder(root3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}