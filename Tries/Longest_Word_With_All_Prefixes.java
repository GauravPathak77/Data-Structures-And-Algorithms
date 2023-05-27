import java.util.*;

public class Longest_Word_With_All_Prefixes {
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

    public static String ans = "";
    // Longest word in Trie
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return ;
        }

        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                ans = temp.toString();
            }
            longestWord(root.children[i], temp);
            temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<String> list = new ArrayList<>();
            char ch;
            do{
                System.out.print("Enter word: ");
                String str = sc.next();
                list.add(str);
                System.out.print("Want to enter more String?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');
            
            for (int i = 0; i < list.size(); i++) {
                insert(list.get(i));
            }

            longestWord(root, new StringBuilder(""));
            System.out.println("\nLongest word with all prefixes is " + ans);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
