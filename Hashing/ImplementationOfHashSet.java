import java.util.*;
public class ImplementationOfHashSet {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            HashSet<String> set = new HashSet<>();
            char ch;
            do{
                System.out.print("Enter value in HashSet: ");
                set.add(sc.next());
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');

            System.out.println("\nHashSet is: ");
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                System.out.print(it.next() + "  ");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
