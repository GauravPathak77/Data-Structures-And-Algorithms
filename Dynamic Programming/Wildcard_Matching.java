import java.util.*;
public class Wildcard_Matching {
    public static boolean isMatch(String s, String p){
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1; i<n+1; i++){
            dp[i][0] = false;
        }
        for(int j=1; j<m+1; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter string: ");
            String s = sc.next();
            System.out.print("Enter pattern to match: ");
            String p = sc.next();
            if(isMatch(s, p)){
                System.out.println("Pattern " + p + " matched with string " + s);
            }else{
                System.out.println("Pattern " + p + " does not match with string " + s);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
