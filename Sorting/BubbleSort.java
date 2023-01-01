import java.util.*;
public class BubbleSort{
    public static void bubbleSort(int arr[],int n){
        for(int i=0; i<n-1; i++){
            for(int j=0; j<i+1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("After Sorting: ");
        for(int i=0; i<n; i++){
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
            for(int i=0; i< size; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println("Before Sorting: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + "  ");
            }
            System.out.println();
            bubbleSort(arr,size);
        }
    }
}
