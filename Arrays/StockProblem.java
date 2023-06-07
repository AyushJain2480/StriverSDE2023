import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class StockProblem{

    public static int maximumProfit(ArrayList<Integer> prices){
        Integer[] arr = prices.toArray(new Integer[0]);
        int n = arr.length;
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(arr[i],min);
            maxProfit = Math.max(maxProfit, arr[i] - min);
        }
        return maxProfit;
    }
}
