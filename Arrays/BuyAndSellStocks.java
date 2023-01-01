import java.util.*;
public class BuyAndSellStocks {
    public static void maxProfit(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<7; i++){
            if(prices[i] > buyPrice) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
            else{
                buyPrice = prices[i];
            }
        }
        System.out.println("Maximum Profit is: " + maxProfit);
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int prices[] = new int[7];
            System.out.println("Enter stock prices of seven days: ");
            for (int i = 0; i<7; i++) {
                prices[i] = sc.nextInt();
            }
            maxProfit(prices);
        }
    } 
}
