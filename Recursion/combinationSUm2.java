// Leetcode 
// COmbination sum I- we can select one element multiple times
class Solution {
    
    public void f(int ind, int[] arr, int target,List<List<Integer>> ans ,List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds)); // deep copy
            }
            return;
        }
        // pick
        if(arr[ind] <= target){
        // add element into ds and pass into the function    
        ds.add(arr[ind]);
        // ind again because we can select the same element again    
        f(ind, arr, target - arr[ind], ans , ds);
        // backtracking so remove from the ds     
        ds.remove(ds.size() - 1);
        }
        // not pick
        f(ind + 1, arr, target , ans , ds); 
    }
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        f(0,arr,target, res, new ArrayList<>());
        return res;
    }
}



import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        // Convert the ArrayList to an array for sorting
        Integer[] nums = arr.toArray(new Integer[0]);
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>(), target, ansList);
        return ansList;
    }
    
    public static void helper(int ind, Integer[] nums, ArrayList<Integer> ds, int target, ArrayList<ArrayList<Integer>> ansList) {
        if (target < 0)
            return;
        if (target == 0)
            ansList.add(new ArrayList<>(ds));
       
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;
            
            ds.add(nums[i]);
            helper(i + 1, nums, ds, target - nums[i], ansList);
            ds.remove(ds.size() - 1);
        }
    }
}
