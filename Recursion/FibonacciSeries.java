import java.util.*;
public class FibonacciSeries {
    public static int fibo(int n){
        if(n <= 1){
            return n;
        }

        return (fibo(n-1) + fibo(n-2));
    }
    public static void main (String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter limit to find fibonacci series: ");
            int terms = sc.nextInt();
             // Check if the input is valid
        if (terms <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("Fibonacci series:");
            for (int i = 0; i < terms; i++) {
                System.out.print(fibo(i) + " ");
            }
        }
    }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
