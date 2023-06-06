/// O(M * N) extra space
import java.io.*;
import java.util.* ;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int matrix[][] = new int[rows][cols];
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    matrix[i][j] = sc.nextInt(); 
                }
            }
            System.out.println(Arrays.toString(matrix));
            setZeros(matrix);
        }
    }
    public static void setZeros(int matrix[][]) {
       int rows = matrix.length; 
       int cols = matrix[0].length;
       boolean[] zeroRows = new boolean[rows];
       boolean[] zeroCols = new boolean[cols];
       for(int row = 0; row < rows; row++){
           for(int col = 0; col < cols; col++){
               if(matrix[row][col] == 0){
                   zeroRows[row] = true;
                   zeroCols[col] = true;
               }
           }
       }
       for(int i = 0; i < rows; i++){
          if(zeroRows[i]){ 
            for(int j = 0; j < cols; j++){
                matrix[i][j] = 0;
            }
          }
       }
       for(int j = 0; j < cols; j++){
           if(zeroCols[j]){
             for(int i = 0; i < rows; i++){
               matrix[i][j] = 0;
             }
           }
       }
    }
}
