import java.util.*;
public class SortedArray {
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length - 1){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter elements in array: ");
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            
            if(isSorted(arr, 0)){
                System.out.println("Array is sorted");
            }
            else{
                System.out.println("Array is not sorted");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
