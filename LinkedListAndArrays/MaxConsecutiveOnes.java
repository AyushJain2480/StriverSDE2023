import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> nums , int n, int k) {
	  int max = 0;
      int i = 0;
      int count = 0;  
      for(int j = 0; j < n; j++){
          // Before while loop we write the condition 
          // where window is not valid
          // we have to create a count variable (smthng like that)
          // and continously acc to condition we should incr or decr it 
          // when it satisy the while loop condition means our window size is not correct it so we correct it than
          // idea is if we have k or less than k 0's in the array of 1's we can include them and calc the max 
          // but whenever no of 0's exceeds k that means we cant check for futher arrays before deleting the 0's
          // to make the window valid.
          if(nums.get(j) == 0) count++;
          while(count > k){
              if(nums.get(i) == 0) count--;
              i++;
          }
          // after while loop our window size is valid
          // so we can calculate whatever is required
          // see I am writing this line after while loop because because before if window is correct than it will work
          // while will not run and after while ran we have to again calc max
          max = Math.max(max, j - i + 1);
      } 
      return max;
	}
}

