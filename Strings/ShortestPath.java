import java.util.*;
public class ShortestPath {
    public static float getShortestPath(String path){
        int x = 0, y = 0;
        for(int i=0; i<path.length(); i++){
            char ch = path.charAt(i);
            if(ch == 'N'){
                y++;
            }
            else if(ch == 'S'){
                y--;
            }
            else if(ch == 'E'){
                x++;
            }
            else if(ch == 'W'){
                x--;
            }
        }
        int X = x*x;
        int Y = y*y;
        return (float)Math.sqrt(X + Y);
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter string of path containing W,E,N,S: ");
            String path = sc.next();
            float shortPath = getShortestPath(path);
            System.out.println("Shortest Path is " + shortPath);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
