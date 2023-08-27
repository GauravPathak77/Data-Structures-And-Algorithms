import java.util.*;
public class Matrix_Chain_Multiplication_Memoization {
    public static int mcmMem(int arr[], int i, int j, int dp[][]){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }
        return dp[i][j] = ans;
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of matrices: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter size of matrix " + (i + 1) + " : ");
                arr[i] = sc.nextInt();
            }
            int dp[][] = new int[n][n];
            System.out.println("Minimum cost of matrix chain multiplication is: " + mcmMem(arr, 1, n - 1, dp));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
