import java.util.*;
public class Fibonacci_Tabulation {
    public static int fib(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter value of n to find Fibonacci: ");
            int n = sc.nextInt();
            System.out.println("\nResult: " + fib(n));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
