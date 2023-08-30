import java.util.*;
public class Zero_One_Knapsack_Tabulation {
    public static int knapsackTab(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else{
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void print(int dp[][]){
        System.out.println("2D Array is: ");
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
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
                System.out.print("Enter value of item " + (i + 1) + " : ");
                val[i] = sc.nextInt();
                System.out.print("Enter weight of item " + (i + 1) + " : ");
                wt[i] = sc.nextInt();
            }
            System.out.println();
            int max = knapsackTab(val, wt, W);
            System.out.println("Maximum profit is: " + max);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
