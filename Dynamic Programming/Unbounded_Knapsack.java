import java.util.*;
public class Unbounded_Knapsack {
    public static int UnboundedKnapsack(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<W+1; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                // valid
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                }
                // invalid
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void print(int dp[][]) {
        System.out.println("2D Array is: ");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
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
                System.out.print("Enetr value of item " + (i + 1) + " : ");
                val[i] = sc.nextInt();
                System.out.print("Enetr weight of item " + (i + 1) + " : ");
                wt[i] = sc.nextInt();
            }
            System.out.println();
            int max = UnboundedKnapsack(val, wt, W);
            System.out.println("\nMaximum profit is: " + max);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
