import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		int[][] dp = new int[N - 1][N - 1];

      for(int g = 0; g < dp.length; g++){
			for(int i = 0, j = g; j < dp.length; i++, j++){
				if(g == 0){
					dp[i][j] = 0;
				}
				else if(g == 1){
            dp[i][j] = arr[i] * arr[j] * arr[j + 1];
				}else{
					int min = Integer.MAX_VALUE;
          for(int k = i; k < j; k++){
						// i , k left half k + 1, j right half
						int lc = dp[i][k];
						int rc = dp[k + 1][j];
						int mc = arr[i] * arr[k + 1] * arr[j + 1];
						int tc = lc + rc + mc;
						min = Math.min(min,tc);
					}
					dp[i][j] = min;
				}
			}
		}
		return dp[0][dp.length - 1];		
	}
}
