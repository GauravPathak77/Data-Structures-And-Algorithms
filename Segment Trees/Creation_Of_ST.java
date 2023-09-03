import java.util.*;
public class Creation_Of_ST{
    static int trees[];
    public static void init(int n){
        trees = new int[4*n];
    }
    public static int buildST(int arr[], int i, int start, int end){
        if(start == end){
            trees[i] = arr[i];
            return arr[i];
        }
        int mid = (start + end)/2;
        buildST(arr, 2*i+1, start, mid);
        buildST(arr, 2*i+1, mid+1, end);
        trees[i] = trees[2*i+1] + trees[2*i+2];
        return trees[i];
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter number of nodes: ");
            int n = sc.nextInt();
            init(n);
            for(int i=0; i<n; i++){
                System.out.print("Enter value at index " + i + " : ");
                trees[i] = sc.nextInt();
            }
            System.out.println("Segment Trees is: ");
            for(int i=0; i<n; i++){
                System.out.print(trees[i] + " ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}