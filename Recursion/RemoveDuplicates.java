import java.util.*;

public class RemoveDuplicates {
    public static void removeDuplicates(boolean map[], String str, StringBuilder newStr, int idx) {
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);

        if(map[currChar - 'a'] == true){
            removeDuplicates(map, str, newStr, idx+1);
        }
        else{
            map[currChar - 'a'] = true;
            removeDuplicates(map, str, newStr.append(currChar), idx + 1);
        }
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter any String: ");
            String str = sc.next();
            System.out.println("After removing duplicates: ");
            boolean map[] = new boolean[26];
            Arrays.fill(map, false);
            removeDuplicates(map, str, new StringBuilder(), 0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
