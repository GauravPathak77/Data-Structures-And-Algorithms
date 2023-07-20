import java.util.*;
public class Target_Sum_Subset {
    public static boolean targeSumSubset(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                int v = arr[i-1];
                // include
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                // exclude
                else if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    public static void print(boolean dp[][]) {
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
            System.out.print("Enter the value of target sum: ");
            int sum = sc.nextInt();
            System.out.print("How many numbers are available? ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enetr number " + (i + 1) + " : ");
                arr[i] = sc.nextInt();
            }
            System.out.println();
            if(targeSumSubset(arr, sum)){
                System.out.println("There exist subsets that give target sum");
            }
            else{
                System.out.println("No subset exists that give target sum");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
