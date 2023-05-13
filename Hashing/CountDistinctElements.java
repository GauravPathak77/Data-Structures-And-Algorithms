import java.util.*;
public class CountDistinctElements {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            HashSet<Integer> set = new HashSet<>();
            char ch;
            do{
                System.out.print("Enter any number: ");
                set.add(sc.nextInt());
                System.out.print("Want to add more numbers?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');

            System.out.println("\nYou entered " + set.size() + " distinct elements.");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
