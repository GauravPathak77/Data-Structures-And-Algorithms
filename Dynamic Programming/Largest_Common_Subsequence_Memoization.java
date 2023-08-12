import java.util.*;
public class Largest_Common_Subsequence_Memoization {
    public static int lcs(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcs(str1, str2, n-1, m-1, dp)+1;
        }
        else{
            int ans1 = lcs(str1, str2, n-1, m, dp);
            int ans2 = lcs(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first String: ");
            String str1 = sc.next();
            System.out.print("Enter second String: ");
            String str2 = sc.next();
            int n = str1.length(), m = str2.length();
            int dp[][] = new int[n+1][m+1];
            for(int i=0; i<n+1; i++){
                for(int j=0; j<m+1; j++){
                    dp[n][m] = -1;
                }
            }
            int max = lcs(str1, str2, n, m, dp);
            System.out.println("Largest Common Subsequence is: " + max);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
