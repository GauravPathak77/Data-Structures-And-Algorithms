import java.util.*;
public class CountingSort {
    public static void countingSort(int arr[], int n){
        int largest = Integer.MIN_VALUE;;
        for(int i=0; i<n; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        int count[] = new int[largest+1];

        for (int i = 0; i <count.length; i++) {
            count[i] = 0;
        }

        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                arr[j++] = i;
                count[i]--;
            }
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
            countingSort(arr, size);
        }
    }
}
