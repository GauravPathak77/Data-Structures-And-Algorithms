import java.util.*;
public class XraiseN {
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        return x*power(x, n-1);
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter base value: ");
            int x = sc.nextInt();
        
            System.out.println("Enter value of exponent: ");
            int n = sc.nextInt();
            System.out.println("\n" + x + " raise " + n + " is: " + power(x, n));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
