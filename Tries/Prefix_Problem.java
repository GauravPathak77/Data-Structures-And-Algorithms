import java.util.*;

public class Prefix_Problem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
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
            else{
                curr.freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // find Prefix
    public static void findPrefix(Node root, String ans){
        if(root == null){
            return;
        }
        if(root.freq == 1){
            System.out.print(ans + "  ");
            return;
        }
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            char ch;
            do {
                System.out.print("Enter any String: ");
                insert(sc.next());
                System.out.print("Want to enter more String?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.println("\nPrefix: ");
            root.freq = -1;
            findPrefix(root, "");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}