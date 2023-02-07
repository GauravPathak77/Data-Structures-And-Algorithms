import java.util.*;
public class BinarySearch{
    public static int binarySearch(int numbers[], int key){
        int start = 0, end = numbers.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            
            //comparison
            if(numbers[mid] == key){
                return mid;
            }
            //left
            if(numbers[mid] > key){
                end = mid-1;
            }
            //right
            else if(numbers[mid] < key){ 
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many numbers you want to enter? ");
            int size = sc.nextInt();
            int num[] = new int[size];
            System.out.println("Enter numbers: ");
            for (int i = 0; i < size; i++) {
                num[i] = sc.nextInt();
            }
            System.out.print("Which number you want to search? ");
            int key = sc.nextInt();
            int loc = binarySearch(num, key);
            if (loc != -1) {
                System.out.println(key + " found at position " + (loc+1));
            } else {
                System.out.println(key + " not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
