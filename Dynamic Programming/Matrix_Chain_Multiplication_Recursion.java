import java.util.*;
public class Matrix_Chain_Multiplication_Recursion {
    public static int mcm(int arr[], int i, int j){
        if(i == j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter number of matrices: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                System.out.print("Enter size of matrix " + (i+1) + " : ");
                arr[i] = sc.nextInt();
            }
            System.out.println("Minimum cost of matrix chain multiplication is: " + mcm(arr, 1, n-1));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
