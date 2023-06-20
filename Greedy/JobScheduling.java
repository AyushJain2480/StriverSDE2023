import java.util.* ;
import java.io.*; 
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1]));

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i][0] > maxi) {
                maxi = jobs[i][0];
            }
        }

        int result[] = new int[maxi + 1];

        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        int jobProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i][0]; j > 0; j--) {
                // Free slot found
                if (result[j] == -1) {
                    result[j] = i;
                    jobProfit += jobs[i][1];
                    break;
                }
            }
        }
        return jobProfit;
    }
}
