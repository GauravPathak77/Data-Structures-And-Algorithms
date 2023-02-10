import java.util.*;
public class ChocolaProblem {
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("How many rows chocolate have? ");
            int m = sc.nextInt();
            System.out.print("How many columns chocolate have? ");
            int n = sc.nextInt();
            Integer costHor[] = new Integer[m-1];
            for(int i=0; i<costHor.length; i++){
                System.out.print("Enter cost of row " + (i+1) + ": ");
                costHor[i] = sc.nextInt();
            }
            Integer costVer[] = new Integer[n-1];
            for (int j = 0; j < costVer.length; j++) {
                System.out.print("Enter cost of column " + (j+1) + ": ");
                costVer[j] = sc.nextInt();
            }
            Arrays.sort(costHor, Collections.reverseOrder());
            Arrays.sort(costVer, Collections.reverseOrder());
            int h = 0, v = 0;
            int hp = 1, vp = 1;
            int cost = 0;
            while(h < costHor.length && v < costVer.length){
                if(costVer[v] <= costHor[h]){    
                    // Horizontal Cut
                    cost += (costHor[h] * vp);
                    hp++;
                    h++;
                }
                else{
                    // Vertical Cut
                    cost += (costVer[v] * hp);
                    vp++;
                    v++;
                }
            }
            while(h < costHor.length){
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            while(v < costVer.length){
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
            System.out.println("Minimum cost of cuts is " + cost);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
