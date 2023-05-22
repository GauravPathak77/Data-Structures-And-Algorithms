import java.util.*;
public class StartsWith_Problem {
    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }
    // Insertion
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    // StartsWith
    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
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

            System.out.print("\nEnter prefix string: ");
            String prefix = sc.next();
            if(startsWith(prefix)){
                System.out.println("Prefix exist");
            }
            else{
                System.out.println("Prefix not exist");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
