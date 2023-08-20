import java.util.*;
public class Wildcard_Matching_Tabulation {
    public static int catalanTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] = dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter value of n to find Catalan's Number: ");
            int n = sc.nextInt();
            System.out.println("Catalan's Number is: " + catalanTab(n));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
