import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        long trapWater = 0L;
        long[] left = new long[n];
        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(arr[i],left[i - 1]);
        }
        

        long[] right = new long[n];
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
           right[i] = Math.max(arr[i],right[i + 1]);
        }

        for(int i = 0; i < n; i++){
              trapWater += Math.min(left[i],right[i]) - arr[i];
        }

        return trapWater;
    }
}
