import java.util.*;
public class Minimum_Partitioning {
    public static int minPartition(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        int W = sum/2;
        int dp[][] = new int[n+1][W+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = sc.nextInt();
            int numbers[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter element " + (i+1) + " : ");
                numbers[i] = sc.nextInt();
            }
            int min = minPartition(numbers);
            System.out.println("\nMinimum difference is: " + min);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
