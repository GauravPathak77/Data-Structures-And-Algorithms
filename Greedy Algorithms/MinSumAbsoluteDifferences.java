import java.util.*;
public class MinSumAbsoluteDifferences{
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter size of two arrays: ");
            int size = sc.nextInt();
            int A[] = new int[size];
            System.out.println("Enter elements in first array: ");
            for(int i=0; i<size; i++){
                A[i] = sc.nextInt();
            }
            int B[] = new int[size];
            System.out.println("Enter elements in second array: ");
            for (int i = 0; i < size; i++) {
                B[i] = sc.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B);
            int minDiff = 0;
            for(int i=0; i<size; i++){
                minDiff += Math.abs(A[i] - B[i]);
            }
            System.out.println("Minimum Absolute Difference is: " + minDiff);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}