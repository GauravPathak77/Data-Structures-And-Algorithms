import java.util.*;
public class AllOccurence {
    public static void allOccurence(int arr[], int key, int i) {
        // base case
        if(i == arr.length) {
            return;
        }
        // kaam
        if(arr[i] == key) {
            System.out.print(i+" ");
        }
        allOccurence(arr, key, i+1);
    } 
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter size of array: ");
            int size = sc.nextInt();
            System.out.println("Enter elements in array: ");
            int arr[] = new int[size];
            for(int i=0; i<size; i++){
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter element to find occurence: ");
            int key = sc.nextInt();
            allOccurence(arr, key, 0);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
