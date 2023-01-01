import java.util.*;
public class Prefix_Array_Method {
    public static void maxSubarraySum(int arr[], int n) {
        int cs = 0, ms = Integer.MIN_VALUE;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        for(int i=0; i<n; i++){
            int start = i;
            for(int j=i; j<n; j++){
                int end = j;
                cs = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                ms = Math.max(cs,ms);
            }
        }
        System.out.println("Maximum SubArray Sum = " + ms);
    }
    public static void main(String ars[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int size;
            System.out.println("Enter Size of array");
            size = sc.nextInt();
            int arr[] = new int[size];
            System.out.println("Enter elements in an array: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            maxSubarraySum(arr, size);
        }
    } 
}
