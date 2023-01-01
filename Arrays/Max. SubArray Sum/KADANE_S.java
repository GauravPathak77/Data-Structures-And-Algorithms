import java.util.*;
public class KADANE_S {
    public static void maxSubarraySum(int arr[], int n) {
        int cs = 0, ms = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            cs+= arr[i];
            if(cs<0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        System.out.println("Maximum SubArray Sum = " + ms);
    }

    public static void main(String ars[]){
        try (Scanner sc = new Scanner(System.in)) {
            int size;
            System.out.println("Enter Size of array");
            size = sc.nextInt();
            int arr[] = new int[size];
            System.out.println("Enter elements in an array: ");
            for(int i=0; i<size; i++){
                arr[i] = sc.nextInt();
            }
            maxSubarraySum(arr,size);
        }
    }
}
