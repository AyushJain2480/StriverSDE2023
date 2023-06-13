import java.io.*;
import java.util.* ;

public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      boolean flag = fourSum(arr, target);
      if(flag){
        return "Yes";
      }
      return "No";
  }

    public static boolean twoSum(int[] nums, int si, int ei, long target) {
        int left = si;
        int right = ei;
        while (left < right) {
            if (left != si && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    
    public static boolean threeSum(int[] nums, int start ,long target){
        int n = nums.length;
        if(n - start < 3) return false;

        for(int i = start; i <= n - 3; i++){
            if(i != start && nums[i] == nums[i - 1]){
                continue;
            }
            int val1 = nums[i];
            if (twoSum(nums, i + 1, n - 1, target - val1)) {
                return true;
            }
        }
       return false;
    }
    
    public static boolean fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n < 4) return false;
        
        Arrays.sort(nums);
        
        for(int i = 0; i <= n - 4; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int val1 = nums[i];
            if(threeSum(nums, i + 1, (long) target - val1)) {
                return true;
            }
        }
        return false;
    }
}
