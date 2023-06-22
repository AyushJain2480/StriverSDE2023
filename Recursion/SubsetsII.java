// passed in leetcode bruteforce O(2^n) - unique subsets 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> sub = new ArrayList<>(subsets.get(i));
                sub.add(num);
                subsets.add(sub);
            }
        }
        return subsets;
    }
}

// SUbset I from leetcode 
// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       // than only you will be able to avoid duplicates and apply recursion 
       List<List<Integer>> ansList = new ArrayList<>();
       helper(0, nums, new ArrayList<Integer>(), ansList); 
       return ansList; 
    }
    
    public void helper(int ind, int[] nums,List<Integer> ds, List<List<Integer>> ansList){
        ansList.add(new ArrayList<>(ds));
        for(int i = ind; i < nums.length; i++){
            ds.add(nums[i]);
            helper(i + 1,nums,ds,ansList);
            ds.remove(ds.size() - 1);
        }
    }
}


// Subsets 2 from leetcode 

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // than only you will be able to avoid duplicates and apply recursion 
       Arrays.sort(nums);
       List<List<Integer>> ansList = new ArrayList<>();
       helper(0, nums, new ArrayList<Integer>(), ansList); 
       return ansList; 
    }
    
     public void helper(int ind, int[] nums,List<Integer> ds, List<List<Integer>> ansList){
        ansList.add(new ArrayList<>(ds)); // deep copy of ds and add it to final ans
        for(int i = ind; i < nums.length; i++){
            // if it is not the first and equal to prev skip it - duplicate
            if(i != ind && nums[i] == nums[i -1])continue;
            
            ds.add(nums[i]);
            helper(i + 1,nums,ds,ansList);
            ds.remove(ds.size() - 1);
        }
    }
}
