import java.util.*;
public class Subarray_Sum_EqualTO_k {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            char ch;
            do {
                System.out.print("Enter element: ");
                list.add(sc.nextInt());
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');
            System.out.print("\nEnter value of k: ");
            int k = sc.nextInt();
            int sum = 0, ans = 0;
            map.put(0,1);
            for(int i=0; i<list.size(); i++){
                sum += list.get(i);
                if(map.containsKey(sum - k)){
                    ans += map.get(sum-k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            System.out.println("Subarray having Sum equal to " + k + ": " + ans);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
