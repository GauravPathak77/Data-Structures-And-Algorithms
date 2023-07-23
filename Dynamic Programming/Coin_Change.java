import java.util.*;
public class Coin_Change {
    public static int coinChange(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            dp[i][0] = 1;
        }
        for(int j=0; j<sum+1; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the change to find: ");
            int sum = sc.nextInt();
            System.out.print("Enter number of coins available: ");
            int n = sc.nextInt();
            int coins[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enetr value of coin " + (i + 1) + " : ");
                coins[i] = sc.nextInt();
            }
            System.out.println();
            int change = coinChange(coins, sum);
            System.out.println("\nMaximum profit is: " + change);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
