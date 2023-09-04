import java.util.*;
public class Queries_On_ST {
    static int trees[];
    
    public static void init(int n) {
        trees = new int[4 * n];
    }

    public static int buildST(int arr[], int i, int start, int end) {
        if (start == end) {
            trees[i] = arr[i];
            return arr[i];
        }
        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid);
        buildST(arr, 2 * i + 1, mid + 1, end);
        trees[i] = trees[2 * i + 1] + trees[2 * i + 2];
        return trees[i];
    }
    public static int getSumUtil(int i, int si, int sj, int qi, int qj){
        if(qj<=si || qi>=sj){
            return 0;
        }
        else if(qi<=si && qj>=sj){
            return trees[i];
        }
        else{
            int mid = (si+sj)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }
    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of nodes: ");
            int n = sc.nextInt();
            init(n);
            for (int i = 0; i < n; i++) {
                System.out.print("Enter value at index " + i + " : ");
                trees[i] = sc.nextInt();
            }
            System.out.print("Enter the starting index of subarray: ");
            int qi = sc.nextInt();
            System.out.print("Enter the ending index of subarray: ");
            int qj = sc.nextInt();
            System.out.println("Subarray sum is: " + getSum(trees, qi, qj));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
