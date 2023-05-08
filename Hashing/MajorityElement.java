import java.util.*;

public class MajorityElement {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            ArrayList<Integer> list = new ArrayList<>();
            char ch;
            do{
                System.out.print("Enter value: ");
                int data = sc.nextInt();
                list.add(data);
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<list.size(); i++){
                map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
            }

            System.out.println("\nMajority Element: ");
            for(Integer key : map.keySet()){
                if(map.get(key) > list.size()/3){
                    System.out.print(key + " ");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
