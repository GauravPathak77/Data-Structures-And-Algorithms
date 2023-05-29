import java.util.*;
public class Implementation_Of_Array{
    public static void main(String  args[]) {
         try(Scanner sc = new Scanner(System.in)){
            int num[] = new int[100];
            System.out.println("Enter size of array: ");
            int n = sc.nextInt();
            int i;
            System.out.println("INTPUT");
            System.out.println("Enter element in an array: ");
            for(i = 0; i<n; i++) {
                num[i] = sc.nextInt();
            }
                System.out.println("OUTPUT");
                for (i = 0; i < n; i++) {
                    System.out.print(num[i]);
                }
            }catch(Exception e){
                System.out.println(e);
            }
}
}