// import java.util.*;
public class SizeOfLargestInBT {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    static class Info{
        boolean isBST;
        int size;
        int max;
        int min;

        public Info(boolean isBST, int size, int max, int min){
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, max, min);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, max, min);
        }
        return new Info(false, size, max, min);
    }
}
