import java.util.*;
public class LinkedHASHMap {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
            char ch;
            do {
                System.out.print("Enter key on HashMap: ");
                String key = sc.next();
                System.out.print("Enter value for Key: ");
                int value = sc.nextInt();
                lhm.put(key, value);
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');
            System.out.println("\nLinkedHashMap is: " + lhm);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
