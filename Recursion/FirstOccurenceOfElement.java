import java.util.*;
public class FirstOccurenceOfElement {
    public static int firstOccurence(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter elements in array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("\nEnter element to find occurence: ");
            int key = sc.nextInt();

            int i = firstOccurence(arr, key, 0);
            if(i != -1) {
                System.out.println("First occurence of element is: " + i);
            } else {
                System.out.println("Element not exist");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
