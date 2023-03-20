import java.util.*;
public class Factorial {

    public static int fact(int n){
        if(n == 0){
            return 1;
        }

        return n*fact(n-1);
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter any number to find Factorial: ");
            int n = sc.nextInt();
            System.out.println("Factorial = " + fact(n));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
