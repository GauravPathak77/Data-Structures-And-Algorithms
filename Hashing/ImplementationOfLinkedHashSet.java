import java.util.*;

public class ImplementationOfLinkedHashSet {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedHashSet<String> lset = new LinkedHashSet<>();
            char ch;
            do {
                System.out.print("Enter value in LinkedHashSet: ");
                lset.add(sc.next());
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.println("\nLinkedHashSet is: ");
            Iterator<String> it = lset.iterator();
            while(it.hasNext()){
                System.out.print(it.next() + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

