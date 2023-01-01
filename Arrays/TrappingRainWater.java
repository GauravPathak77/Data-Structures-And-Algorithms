import java.util.*;
public class TrappingRainWater {
    public static void trapRainWater(int height[], int n) {
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        int trappedWater = 0;
        for(int i=0; i<n; i++) {
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        System.out.println("Trapped Rain Water is " + trappedWater);
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)) {
            int size;
            System.out.println("Enter number of bars: ");
            size = sc.nextInt();
            int height[] = new int[size];
            System.out.println("Enter height of bars: ");
            for(int i=0; i<size; i++) {
                height[i] = sc.nextInt();
            }
            trapRainWater(height, size);
        }
    }
}
