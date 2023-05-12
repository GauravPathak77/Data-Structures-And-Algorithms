import java.util.*;

public class Implementation_Of_TreeSet {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            TreeSet<String> ts = new TreeSet<>();
            char ch;
            do {
                System.out.print("Enter value in TreeSet: ");
                ts.add(sc.next());
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.println("\nLinkedHashSet is: " + "\n" + ts);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}