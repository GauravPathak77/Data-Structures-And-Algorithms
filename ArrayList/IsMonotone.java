import java.util.*;
public class IsMonotone{
    public static boolean isMonotone(ArrayList<Integer> nums) {
        boolean inc = true;
        boolean dec = true;
        for(int i =0; i< nums.size()-1 ; i++) {
            if(nums.get(i) > nums.get(i+1)) 
                inc = false;
            
            if(nums.get(i) < nums.get(i+1)) 
                dec = false;
        }
        return inc || dec;
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
        ArrayList<Integer> nums = new ArrayList<>();
        char choice;
        do {
            System.out.println("Enter elements: ");
            int data = sc.nextInt();
            nums.add(data);
            System.out.print("Do you Want to enter more values(y/n)? ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        if(isMonotone(nums)){
            System.out.print("Monotone");
        }
        else{
            System.out.print("Not Monotone");
        }
        }catch(Exception e){
        System.out.println(e);
        }
    }
}