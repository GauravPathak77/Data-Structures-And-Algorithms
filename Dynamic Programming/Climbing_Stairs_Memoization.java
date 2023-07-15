import java.util.*;
public class Climbing_Stairs_Memoization {
    public static int countWays(int n, int ways[]){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = countWays(n-1, ways) + countWays(n-2, ways);
        return ways[n];
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter value of n to find ways to climb nth stairs: ");
            int n = sc.nextInt();
            int ways[] = new int[n+1];
            Arrays.fill(ways, -1);
            System.out.println("There are " + countWays(n, ways) + " ways to climb " + n + " stairs.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
