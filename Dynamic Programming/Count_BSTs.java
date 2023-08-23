import java.util.*;
public class Count_BSTs {
    public static int countBST(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of nodes available: ");
            int n = sc.nextInt();
            System.out.println(countBST(n) + " BSTs can be formed through " + n + " nodes.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
