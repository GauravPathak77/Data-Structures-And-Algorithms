import java.util.*;
public class Fibonacci{
    public static int fib(int n, int[] f){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter value of n to find Fibonacci: ");
            int n = sc.nextInt();
            int[] f = new int[n+1];
            System.out.println("\nResult: " + fib(n, f));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}