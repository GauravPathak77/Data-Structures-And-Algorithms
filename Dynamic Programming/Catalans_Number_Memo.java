import java.util.*;
public class Catalans_Number_Memo {
    public static int catalanMemo(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;
        for(int i=0; i<=n-1; i++){
            ans = catalanMemo(i, dp)*catalanMemo(n-i-1, dp);
        }
        return ans;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter value of n to find Catalan's Number: ");
            int n = sc.nextInt();
            int dp[] = new int[n];
            Arrays.fill(dp,-1);
            System.out.println("Catalan's Number is: " + catalanMemo(n, dp));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
