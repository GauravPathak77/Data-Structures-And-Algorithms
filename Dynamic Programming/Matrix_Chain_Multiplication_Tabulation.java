import java.util.*;
public class Matrix_Chain_Multiplication_Tabulation {
    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = 0;
        }

        for(int len = 2; len <= n-1; len++){
            for(int i = 1; i<= n-len; i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
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
            System.out.println("Minimum cost of matrix chain multiplication is: " + mcmTab(arr));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
