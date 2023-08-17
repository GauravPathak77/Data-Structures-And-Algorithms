import java.util.*;
public class Catalans_Number {
    public static int catalanRec(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int ans = 0;
        for(int i=0; i<= n-1; i++){
            ans += catalanRec(i)*catalanRec(n-i-1);
        }
        return ans;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter small value of n to find Catalan's Number: ");
            int n = sc.nextInt();
            System.out.println("Catalan's Number is: " + catalanRec(n));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
