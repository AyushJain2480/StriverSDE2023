import java.util.* ;
import java.io.*; 

public class Solution {
    public static int maxIncreasingsSumLIS(int[] arr, int n) {
      
        int[] dp = new int[n + 1];
        dp[0] = arr[0];
        int ans = dp[0];

        for(int i = 1; i < n; i++){
            int maxSum = 0;
            for(int j = 0; j <= i - 1; j++){
                if(arr[i] > arr[j]){
                    maxSum = Math.max(maxSum, dp[j]);
                }
            }
            dp[i] = maxSum + arr[i];
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
