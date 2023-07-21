// LIS
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

// Longest Arithmetic Subsequence of Given Difference
class Solution {
   public int longestSubsequence(int[] arr, int diff){
       int maxList = 0;
       HashMap<Integer,Integer> arithList = new HashMap<>();
       for(int a : arr){
           int prevListLength = arithList.getOrDefault(a - diff,0);
           int newListFora = prevListLength + 1;
           arithList.put(a, newListFora);
           maxList = Math.max(maxList, newListFora);
       }
       return maxList;
   }
}

// Find Number of LIS

class Solution {
    public int findNumberOfLIS(int[] arr) {
      int n = arr.length;
      int[] dp = new int[n];
      int[] count = new int[n];
      
      Arrays.fill(dp,1);
      Arrays.fill(count,1);
      int maxi = 1;
        
      for(int i = 1; i < n; i++){
          for(int j = 0; j <= i - 1; j++){
              if(arr[i] > arr[j]){
                  // if you find the greater lis 
                  if(dp[i] < dp[j] + 1){
                      dp[i] = dp[j] + 1;
                      count[i] = count[j];
                  }
                  // if it is the same of length inc the count only
                  else if(dp[i] == dp[j] + 1){
                      count[i] += count[j];
                  }
              }
          }
          maxi = Math.max(maxi, dp[i]); // lis maxm length
      } 
      int nos = 0;
      for(int i = 0; i < n; i++){
          if(dp[i] == maxi){
              nos += count[i];
          }
      }  
       return nos; 
    }
}
