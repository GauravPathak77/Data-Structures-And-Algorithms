import java.util.*;
public class Largest_Subarray_With_Sum_0 {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            ArrayList<Integer> arr = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            char ch;
            do{
                System.out.print("Enter value in array: ");
                arr.add(sc.nextInt());
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');

            int sum = 0, len = 0;
            for(int j=0; j<arr.size(); j++){
                sum += arr.get(j);
                if(map.containsKey(sum)){
                    len = Math.max(len, j-map.get(sum));
                }
                else{
                    map.put(sum, j);
                }
            }
            System.out.println("\nLargest Subarray with 0 sum is: " + len);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
