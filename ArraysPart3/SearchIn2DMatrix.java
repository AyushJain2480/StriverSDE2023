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
