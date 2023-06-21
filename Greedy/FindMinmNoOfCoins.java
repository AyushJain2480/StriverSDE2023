import java.util.* ;
import java.io.*; 
public class Solution
{
public static int findMinimumCoins(int amount)
    {
        int[] arr = {1000,500,100,50,20,10,5,2,1};

        int curr = 0;
        int bagSize = 0;
        for(int i = 0; i < arr.length; i++){
            while(curr + arr[i] <= amount){
                curr = curr + arr[i];
                bagSize = bagSize + 1;
                if(curr == amount){
                    break;
                }
            }
        }
        return bagSize;
    }
}
