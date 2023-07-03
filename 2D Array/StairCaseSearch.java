import java.util.*;
public class StairCaseSearch {
    public static void stairCaseSearch(int matrix[][], int key){
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                System.out.println("Element found at (" + row + "," + col + ")");
                return;
            }
            
            if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Element not found!");
    }
    public static void main(String args[]){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("How many rows does the sorted matrix have? ");
            int m= sc.nextInt();
            System.out.print("How many columns does the sorted matrix have? ");
            int n = sc.nextInt();
            int matrix[][] = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    System.out.print("Enter element at (" + i + "," + j + "): ");
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.print("Which element do you want to search? ");
            int key = sc.nextInt();
            stairCaseSearch(matrix,key);
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
