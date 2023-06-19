import java.util.PriorityQueue;
import java.util.Arrays;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) { 
       Arrays.sort(at);
       Arrays.sort(dt);

       int i = 0;
       int j = 0;
       int maxTrain = 0;
       int platform = 0;

       while(i < n && j < n){
        if(at[i] <= dt[j]){
            maxTrain++;
            i++;
        }else{
            maxTrain--;
            j++;
        }
        platform = Math.max(platform,maxTrain);
       }
       return platform;
    }
}
