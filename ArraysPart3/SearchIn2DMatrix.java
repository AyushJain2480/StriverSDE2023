 // Approach 1 O(n2) using two for loops
        boolean ans = false;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == target) 
                    ans = true;
            }
        }
        return ans;
        



import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        for(ArrayList<Integer> list : mat){
            int i = Collections.binarySearch(list, target);
            if(i >= 0){
                return true;
            }
        }
        return false;
    }
}


// optimised approach
