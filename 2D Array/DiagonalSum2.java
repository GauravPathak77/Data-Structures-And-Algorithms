import java.util.*;
public class DiagonalSum2 {
    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for(int i=0; i<matrix.length; i++){
            sum += matrix[i][i];
            if(i != matrix.length-i-1){
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        return sum;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter size of rows: ");
            int m = sc.nextInt();
            System.out.print("Enter size of columns: ");
            int n = sc.nextInt();
            int matrix[][] = new int[m][n];
            System.out.println("Enter elements in matrix: ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int sum = diagonalSum(matrix);
            System.out.println("Diagonal sum = " + sum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
