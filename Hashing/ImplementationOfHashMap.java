import java.util.*;
public class ImplementationOfHashMap{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            HashMap<String, Integer> map = new HashMap<>();
            char ch;
            do{
                System.out.print("Enter key on HashMap: ");
                String key = sc.next();
                System.out.print("Enter value for Key: ");
                int value = sc.nextInt();
                map.put(key,value);
                System.out.println("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');

            // System.out.println("\nHashMap is: ");
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}