import java.util.*;

public class XraiseNOptimized {
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower = power(x, n/2);
        halfPower = halfPower * halfPower;

        if(x % 2 != 0){
            halfPower = x * halfPower;
        }
        return halfPower;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter base value: ");
            int x = sc.nextInt();

            System.out.println("Enter value of exponent: ");
            int n = sc.nextInt();
            System.out.println(x + " raise " + n + " is: " + power(x, n));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
