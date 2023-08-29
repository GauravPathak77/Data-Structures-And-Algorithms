import java.util.*;
public class Zero_One_Knapsack_Memoization {
    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]){
        if(W == 0 || n == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] < W){
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1, dp);
            int ans2 = knapsack(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W] = knapsack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the Weight that knapsack can contain: ");
            int W = sc.nextInt();
            System.out.print("Enter number of items available: ");
            int n = sc.nextInt();
            int val[] = new int[n];
            int wt[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter value of item " + (i + 1) + " : ");
                val[i] = sc.nextInt();
                System.out.print("Enter weight of item " + (i + 1) + " : ");
                wt[i] = sc.nextInt();
            }
            int dp[][] = new int[val.length + 1][W+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    dp[i][j] = -1;
                }
            }
            int max = knapsack(val, wt, W, n, dp);
            System.out.println("\nMaximum profit is: " + max);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
