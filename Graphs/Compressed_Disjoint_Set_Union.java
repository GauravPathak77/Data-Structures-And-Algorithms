import java.util.*;
public class Compressed_Disjoint_Set_Union {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    public static void init(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] == rank[parB]){
            par[parB] = par[parA];
            rank[parA]++;
        }
        else if(rank[parA] < rank[parB]){
            par[parA] = par[parB];
        }
        else{
            par[parB] = par[parA]; 
        }
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            init();
            System.out.println("Disjoint Set Union");
            System.out.print(find(3) + " , ");
            union(1,3);
            System.out.print(find(3));

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

