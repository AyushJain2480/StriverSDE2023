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
