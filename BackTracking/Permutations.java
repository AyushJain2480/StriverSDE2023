// Leetcode permutation - Using extra space 
// n! * O(N) (n! for all permutations generating and O(N) for looping)
class Solution {
    
    void f(int[] nums, List<Integer> ds, boolean[] map , List<List<Integer>> ans){
        if(ds.size() == nums.length){ // no need to add now
            ans.add(new ArrayList<>(ds));
            return;
        }
        // everytime start from 0 to the end of the array and check if the element is 
        // present in the map or not if not means we can choose that and mark it true 
        // and add it to ds while returning make it false again and remove from ds
        for(int i = 0; i < nums.length; i++){
            if(!map[i]){
                map[i] = true;
                ds.add(nums[i]);
                f(nums, ds, map, ans);
                map[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] map = new boolean[nums.length];
        f(nums, new ArrayList<Integer>(),map,ans);
        return ans;
    }
}

// coding ninjas permutations of string using extra space of stringBuilder

import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String s) {
        List<String> ans = new ArrayList<>();
        f(s,ans,new StringBuilder(),new boolean[s.length()]);
        return ans;        
    }

    static void f(String s, List<String> ans, StringBuilder sb, boolean[] map){
          
          if(sb.length() == s.length()){
              ans.add(sb.toString());
              return;
          }

          for(int i = 0; i < s.length(); i++){
            if(!map[i]){
               map[i] = true;
               sb.append(s.charAt(i));
               f(s, ans, sb, map);
               map[i] = false;
               sb.deleteCharAt(sb.length() - 1);
            }
          }
    }    
}
