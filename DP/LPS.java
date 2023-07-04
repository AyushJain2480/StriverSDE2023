public class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder().append(s);
        return lcs(s,sb.reverse().toString());
    }
    
    public int lcs(String s , String rev){
    int[][] dp = new int[s.length() + 1][rev.length() + 1];
    
    for(int i = s.length() - 1; i >= 0; i--){
        for(int j = rev.length() - 1; j >= 0; j--){
            if(s.charAt(i) == rev.charAt(j)){
                dp[i][j] = dp[i + 1][j + 1] + 1;
            }else{
                dp[i][j] = Math.max(dp[i][j + 1],dp[i + 1][j]);
            }
        }
    }
     return dp[0][0];   
    }
}
