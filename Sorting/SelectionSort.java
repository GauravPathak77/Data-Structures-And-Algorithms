import java.util.*;
public class SelectionSort{
    public static void selectionSort(int arr[], int n){
        for(int i=0; i<n; i++){
            int minPos = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minPos]){
                    minPos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
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
            selectionSort(arr, size);
        }
    }
}