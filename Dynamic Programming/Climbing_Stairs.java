import java.util.*;
public class Climbing_Stairs {
    public static int countWays(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter value of n to find ways to climb nth stairs: ");
            int n = sc.nextInt();
            System.out.println("There are : " + countWays(n) + " ways to climb " + n + " stairs.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
