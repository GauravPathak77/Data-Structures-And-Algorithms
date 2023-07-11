import java.util.*;
public class Flood_Fill_Algorithm {
    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgcolor){
        // base case
        if(sr < 0 || sc < 0 || sr > image.length || sc > image[0].length || vis[sr][sc] || image[sr][sc] != orgcolor){
            return;
        }
        image[sr][sc] = color;
        // left
        helper(image, sr-1, sc, color, vis, orgcolor);
        // right
        helper(image, sr+1, sc, color, vis, orgcolor);
        // up
        helper(image, sr, sc-1, color, vis, orgcolor);
        // down
        helper(image, sr, sc+1, color, vis, orgcolor);
    }

    public int[][] floofFill(int[][] image, int sr, int sc, int color){
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }
    
}
