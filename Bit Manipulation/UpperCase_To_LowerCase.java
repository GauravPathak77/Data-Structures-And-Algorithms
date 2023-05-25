import java.util.*;
public class UpperCase_To_LowerCase {
    public static void main(String[] args) 
    {
        try(Scanner sc = new Scanner(System.in)){
            // Convert uppercase character to lowercase
            System.out.println("Characters in lowercase: ");
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.print((char) (ch | ' ') + "  ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
