import java.util.*;
public class Union_And_Intersection {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            ArrayList<Integer> arr1 = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
            char ch;
            do{
                System.out.print("Enter element in list1: ");
                arr1.add(sc.nextInt());
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');
            System.out.println();
            do {
                System.out.print("Enter element in list2: ");
                arr2.add(sc.nextInt());
                System.out.print("Want to enter more values?(y/n): ");
                ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i<arr1.size(); i++){
                set.add(arr1.get(i));
            }
            for (int i = 0; i < arr2.size(); i++) {
                set.add(arr2.get(i));
            }
            System.out.println("Union of list1 and list2 is: \n" + set);
            set.clear();
            for (int i = 0; i < arr1.size(); i++) {
                set.add(arr1.get(i));
            }
            System.out.println("Intersection of list1 and list2 is: ");
            for(int i=0; i<arr2.size(); i++){
                if(set.contains(arr2.get(i))){
                    System.out.print(arr2.get(i) + " ");
                    set.remove(arr2.get(i));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
