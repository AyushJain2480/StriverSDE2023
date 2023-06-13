import java.io.*;
import java.util.* ;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] nums, int N) {
         //[4,4,4,5,6,9,9,10,10]
         //[4,5,6]
        
         Arrays.sort(nums);
         int maxLength = 1;
         int count = 1;

         for(int i = 1; i < nums.length; i++){
              if(nums[i] == nums[i - 1] + 1){
                   count++;
              }else if(nums[i] == nums[i - 1]){
                   continue;
              }else{
                  count = 1;
              }
              maxLength = Math.max(maxLength,count);
         }
         return maxLength;
    }
}
