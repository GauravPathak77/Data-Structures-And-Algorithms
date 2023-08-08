import java.util.*;
public class Rod_Cutting {
    public static int rodCutting(int length[], int price[], int totRod){
        int n = price.length;
        int dp[][] = new int[n+1][totRod+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<totRod+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<totRod+1; j++){
                // valid
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the length of rod: ");
            int totRod = sc.nextInt();
            System.out.print("Enter number of pieces of rod available: ");
            int n = sc.nextInt();
            int length[] = new int[n];
            int price[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the length of rod " + (i + 1) + " : ");
                length[i] = sc.nextInt();
                System.out.print("Enter the price of rod " + (i + 1) + " : ");
                price[i] = sc.nextInt();
            }
            System.out.println();
            int max = rodCutting(length, price, totRod);
            System.out.println("\nMaximum profit is: " + max);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
