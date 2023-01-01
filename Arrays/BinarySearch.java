import java.util.*;
public class BinarySearch {
    public static int binarySearch(int arr[], int n, int key) {
        int start = 0;
        int end = n-1;
        int mid;
        while(start <= end) {
            mid = (start + end)/2;
            if(key == arr[mid]) {
                return mid;
            }
            if( arr[mid] > key ) {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[20];
        int size,key;
        System.out.println("Enter Size of array: ");
        size = sc.nextInt();
        System.out.println("Enter Sorted elements in an array: ");
        for(int i=0;i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to find: ");
        key = sc.nextInt();
        System.out.println("Element found at " +  binarySearch(arr,size,key) +1 );
    }
}
