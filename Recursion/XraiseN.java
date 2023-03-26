import java.util.*;
public class XraiseN {
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        return x*power(x, n-1);
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of array: ");
            int size = sc.nextInt();
            int arr[] = new int[size];
            System.out.println("Enter elements in array: ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("\nEnter base: ");
            int x = sc.nextInt();
            System.out.print("Enter power: ");
            int n = sc.nextInt();
            int i = power(x, n);
            if (i != -1) {
                System.out.println("Last occurence of element is: " + i);
            } else {
                System.out.println("Element not exist");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
