import java.util.*;
public class Find_Itinerary_For_Tickets{
    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();
        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }
        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            HashMap<String, String> tickets = new HashMap<>();
            char ch;
            do{
                System.out.print("Enter starting point: ");
                String from = sc.next();
                System.out.print("Enter ending point: ");
                String to = sc.next();
                tickets.put(from,to);
                System.out.print("Want to enter more journey?(y/n): ");
                ch = sc.next().charAt(0);
            }while(ch == 'y' || ch == 'Y');

            System.out.println("\nItinearay is: ");
            String start = getStart(tickets);
            System.out.print(start);
            for(String key : tickets.keySet()){
                System.out.print(" ->\t" + tickets.get(start));
                start = tickets.get(start);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}