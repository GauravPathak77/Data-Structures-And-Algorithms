import java.util.*;

public class HeapSort {
        // heapify
        private static void heapify(int arr[], int i, int n) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int maxIdx = i;

            if (left < n && arr[maxIdx] > arr[left]) {
                maxIdx = left;
            }

            if (right < n && arr[maxIdx] > arr[right]) {
                maxIdx = right;
            }

            // swap
            if (maxIdx != i) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
                heapify(arr, maxIdx, n);
            }
        }

        public static void heapSort(int arr[]){
            int n = arr.length;
            for(int i=n/2; i>=0; i--){
                heapify(arr,i,n);
            }

            for(int i = n-1; i>0; i--){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr,0, i);
            }
        }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter size of heap: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            int idx = 0;
            char ch;
            do {
                System.out.print("Enter value in Heap: ");
                arr[idx] = sc.nextInt();
                idx++;
                System.out.print("Want to enter more values(y/n)? ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            System.out.println("\nHeap is: ");
            heapSort(arr);
            for(int i=0; i<n; i++){
                System.out.println(arr[i]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
