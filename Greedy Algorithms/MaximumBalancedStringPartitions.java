import java.util.*;
public class MaximumBalancedStringPartitions{
    public static int balancedStringSplit(String str, int N){
        int balance = 0, count = 0;
        for(int i=0; i<N; i++){
            if(str.charAt(i) == 'L'){
                balance++;
            }
            else{
                balance--;
            }
            if(balance == 0){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter size of string Containing only L and R: ");
            int N = sc.nextInt();
            System.out.print("Enter string: ");
            String str = sc.next();
            int count = balancedStringSplit(str, N);
            System.out.println("\nGiven String can be partitioned into " + count + " balanced substring");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}