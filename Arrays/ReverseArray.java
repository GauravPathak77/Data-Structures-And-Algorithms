import java.util.*;
public class ReverseArray {
    public static void reverseArr(int arr[],int n) {
        int i,j,temp;
        for(i = 0,j = n-1; i<n/2; i++,j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[20];
        int size;
        System.out.println("Enter Size of array: ");
        size = sc.nextInt();
        System.out.println("Enter Sorted elements in an array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        reverseArr(arr, size);
        System.out.println("Array After sorting: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
