import java.util.*;
public class Unique_Substrings {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    // Insertion
    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // unique substrings = Count of nodes of tries
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter any string to find unique substrings: ");
           String str = sc.next();

           for(int i=0; i<str.length(); i++){
            String s = str.substring(i);
            insert(s);
           }

           System.out.println("Unique Substrings are: " + countNodes(root));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
