import java.util.*;
public class WeakestSoldier {
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx - r2.idx;
            }
            else{
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
            PriorityQueue<Row> pq = new PriorityQueue<>();
            char chR, ch;
            int id = 0;
            do{
                ArrayList<Integer> row = new ArrayList<>();
                do{
                System.out.println("Enter in row " + id + "(1/0):- " + "\n1:Soldier\n2:Civilian");
                int data = sc.nextInt();
                row.add(data);
                System.out.print("Want to enter more values?(y/n): ");
                chR = sc.next().charAt(0);
            }while(chR == 'y' || chR == 'Y');
            matrix.add(row);
            id++;
            System.out.print("Want more rows?(y/n): ");
            ch = sc.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

            for(int i=0; i<matrix.size(); i++){
                int count = 0;
                for(int j = 0; j<matrix.get(0).size(); j++){
                    count += matrix.get(i).get(j) == 1? 1: 0;
                }
                pq.add(new Row(count, i));
            }
            System.out.print("How many weakest soldier you want to find? ");
            int k = sc.nextInt();
            System.out.println("\nWeakest soldiers are: ");
            for(int i=0; i<k; i++){
                System.out.println("R" + pq.remove().idx);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
