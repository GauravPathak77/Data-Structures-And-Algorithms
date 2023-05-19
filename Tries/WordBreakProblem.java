import java.util.*;
public class WordBreakProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
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
            System.out.print("\nEnter any Word: ");
            String key = sc.next();
            if (wordBreak(key)) {
                System.out.println("Word found");
            } else {
                System.out.println("Word not found");
            }
        }
    }
}
