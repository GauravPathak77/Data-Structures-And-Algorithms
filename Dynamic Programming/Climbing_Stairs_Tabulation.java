import java.util.*;
public class Climbing_Stairs_Tabulation {
    public static int countWaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter value of n to find ways to climb nth stairs: ");
            int n = sc.nextInt();
            System.out.println("There are " + countWaysTab(n) + " ways to climb " + n + " stairs.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
