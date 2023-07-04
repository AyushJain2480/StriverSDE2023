import java.util.*;
public class Solution {
	public static int longestIncreasingSubsequence(int arr[]) {
		int n = arr.length;
		int[] dp = new int[n];	
    dp[0] = 1;
		int ans = 1;
		for(int i = 1; i < n; i++){
			int max = 0;
      for(int j = 0; j <= i - 1; j++){
				if(arr[i] > arr[j]){
           max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			ans = Math.max(dp[i],ans);
		}
     return ans;
	}
}
