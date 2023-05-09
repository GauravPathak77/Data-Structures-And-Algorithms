import java.util.*;
public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch, map.get(ch) - 1);
                }
            }
            else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter first String: ");
            String s = sc.next();
            System.out.print("Enter second String: ");
            String t = sc.next();
            if(isAnagram(s,t)){
                System.out.println("Valid Anagram");
            }
            else{
                System.out.println("Invalid Anagram");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
