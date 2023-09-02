import java.util.*;
public class Minimum_Array_Jumps {
    public static int minJumps(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1; j<=i+steps && j<n; j++){
                if(dp[j] != -1){
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        return dp[0];
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of steps array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter value steps from index " + i + " : ");
                arr[i] = sc.nextInt();
            }
            System.out.println("Minimum Jump is: " + minJumps(arr));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
