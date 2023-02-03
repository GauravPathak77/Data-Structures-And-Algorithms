import java.util.*;
public class IndianCoins {
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("How many types of coins do you have? ");
            int size = sc.nextInt();
            Integer coins[] = new Integer[size];
            for(int i=0; i<size; i++){
                System.out.print("Enter amount of coins " + (i+1) + ": ");
                coins[i] = sc.nextInt();
            }
            System.out.print("How much change do you want? ");
            int amount = sc.nextInt();
            int countOfCoins = 0;
            // Sorting in descending order
            Arrays.sort(coins, Comparator.reverseOrder());
            ArrayList<Integer> ans = new ArrayList<>();

            for(int i=0; i<size; i++){
                if(amount >= coins[i]){
                    while(amount >= coins[i]){
                        countOfCoins++;
                        ans.add(coins[i]);
                        amount -= coins[i];
                    }
                }
            }

            System.out.println("The total minimum coins used is: " + countOfCoins);
            System.out.print("Types of Coins used are: ");
            for(int i=0; i<ans.size(); i++){
                System.out.print(ans.get(i) + " ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
