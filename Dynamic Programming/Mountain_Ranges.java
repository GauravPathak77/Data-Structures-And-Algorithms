import java.util.*;
public class Mountain_Ranges {
    public static int mountainRanges(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<i; j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside*outside;
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of pairs: ");
            int n = sc.nextInt();
            System.out.println("From " + n + " pairs " + mountainRanges(n) + " mountains and valleys can possible");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
