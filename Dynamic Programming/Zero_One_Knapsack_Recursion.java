import java.util.*;
public class Zero_One_Knapsack_Recursion {
    public static int knapsack(int val[], int wt[], int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }
        
        if(wt[n-1] <= W){
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
            int ans2 = knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        }
        else{
            return knapsack(val, wt, W, n-1);
        }
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the Weight that knapsack can contain: ");
            int W = sc.nextInt();
            System.out.print("Enter number of items available: ");
            int n = sc.nextInt();
            int val[] = new int[n];
            int wt[] = new int[n];
            for(int i=0; i<n; i++){
                System.out.print("Enter value of item " + (i+1) + " : ");
                val[i] = sc.nextInt();
                System.out.print("Enter weight of item " + (i+1) + " : ");
                wt[i] = sc.nextInt();
            }
            int max = knapsack(val, wt, W, n);
            System.out.println("\nMaximum profit is: " + max);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
