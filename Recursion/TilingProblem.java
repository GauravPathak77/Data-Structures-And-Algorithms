import java.util.*;
public class TilingProblem {
    public static int tilingProblem(int n){
        if(n == 0 || n == 1){
            return 1;
        }
   
        // vertical ways
        int fnm1 = tilingProblem(n-1);
        // horizontal ways
        int fnm2 = tilingProblem(n-2);
        // total ways
        int totalWays = fnm1 + fnm2;

        return totalWays;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter value of n for 2xn tiles: ");
            int n = sc.nextInt();
            System.out.println("Total number of ways of tiling is: " + tilingProblem(n));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
