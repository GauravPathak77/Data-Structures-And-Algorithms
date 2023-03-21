import java.util.*;
public class SumOfFirstnNaturalNumber {
    public static int calcSum(int n){
        if(n == 1){
            return 1;
        }

        int Snm1 = calcSum(n-1);
        int Sn = Snm1 + n;
        return Sn; 
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter limit of sum: ");
            int n = sc.nextInt();
            System.out.println("Sum is: " + calcSum(n));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
