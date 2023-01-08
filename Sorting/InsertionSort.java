import java.util.*;
public class InsertionSort {
    public static void insertionSort(int arr[], int n){
        for(int i=1; i<n; i++){
            int prev = i-1;
            int curr = arr[i];
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[++prev] = curr;
        }
        System.out.println("\nAfter Sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int size;
            System.out.println("Enter size of array: ");
            size = sc.nextInt();
            int arr[] = new int[size];
            System.out.println("Enter elements in an array: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Before Sorting: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + "  ");
            }
            insertionSort(arr, size);
        }
    }
}
