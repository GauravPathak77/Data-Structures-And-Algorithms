import java.util.*;
public class LinearSearch {
    public static int linearSearch(int num[], int key){
        for(int i=0; i<num.length; i++){
            if(num[i] == key){
                return i+1;
            }
        }
        return -1;
    }

public static void main(String args[]) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("How many numbers you want to enter? ");
            int size = sc.nextInt();
            int num[] = new int[size];
            System.out.println("Enter numbers: ");
            for(int i=0; i<size; i++){
                num[i] = sc.nextInt();
            }
            System.out.print("Which number you want to search? ");
            int key = sc.nextInt();
            int loc = linearSearch(num,key);
            if(loc != -1){
                System.out.println(key + " found at position " + loc);
            }
            else{
                System.out.println(key + " not found");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
