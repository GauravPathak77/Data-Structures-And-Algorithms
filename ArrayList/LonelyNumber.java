import java.util.*;
public class LonelyNumber {
    public static void lonely( ArrayList<Integer> nums ) {
        int i,j,flag;
        for(i = 0; i< nums.size() ; i++){
            flag = 0;
            for(j = 0; j< nums.size(); j++) {
                if( nums.get(j) == nums.get(i) + 1 || nums.get(j) == nums.get(i) - 1) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                System.out.print(nums.get(i) + "  ");
            }
        }
    }

     public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);
        System.out.println("\nLonely Numbers are: ");
        lonely(nums);
    }
}
