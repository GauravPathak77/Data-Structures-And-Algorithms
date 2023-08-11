import java.util.*;
public class Largest_Common_Subsequences {
    public static int lcs(String str1, String str2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1, str2, n-1, m-1) + 1;
        }
        else{
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter first String: ");
            String str1 = sc.next();
            System.out.print("Enter second String: ");
            String str2 = sc.next();
            int max = lcs(str1, str2, str1.length(), str2.length());
            System.out.println("Largest Common Subsequence is: " + max);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
