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
}