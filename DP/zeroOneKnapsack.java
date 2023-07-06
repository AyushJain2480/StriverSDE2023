import java.util.ArrayList;

public class Solution {
       public static int maxProfit(ArrayList<Integer> val, ArrayList<Integer> wt, int n, int w) {
	int[][] dp = new int[n + 1][w + 1]; // itms|wts

         for(int i = 1; i < dp.length; i++){
	      for(int j = 1; j < dp[0].length; j++){
		dp[i][j] = dp[i - 1][j];
		if(j >= wt.get(i - 1))  dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt.get(i-1)] + val.get(i-1));
	       }
        }
        return dp[dp.length - 1][dp[0].length - 1];
	}
}
