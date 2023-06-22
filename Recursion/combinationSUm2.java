// Leetcode 
// COmbination sum I- we can select one element multiple times
// c1 -> brute -> O(2^n * k)
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

// I find this easy than the below 

// c2 -> brute -> O(2^n * k * logN) interviewer will not happy with extra logN complexity
// give TLE 
// c2 -> brute -> O(2^n * k * logN)
class Solution {
    
    public void f(int ind, int[] arr, int target,Set<List<Integer>> ans ,List<Integer> ds){
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
        f(ind + 1, arr, target - arr[ind], ans , ds);
        // backtracking so remove from the ds     
        ds.remove(ds.size() - 1);
        }
        // not pick
        f(ind + 1, arr, target , ans , ds); 
    }
    
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        Set<List<Integer>> res = new HashSet<>();
        f(0,arr,target, res, new ArrayList<>());
        return new ArrayList<>(res);
    }
}

// Optimised and accepted solution of COmbination Sum II  -- TC - O(2^n) * k

class Solution {
    
    public void f(int ind, int[] arr, int target,List<List<Integer>> ans ,List<Integer> ds){
         if(target == 0){
             ans.add(new ArrayList<>(ds));
             return;
         }
        
         for(int i = ind; i < arr.length; i++){
             
             if(i > ind && arr[i] == arr[i - 1])continue;
             
             if(arr[i] <= target){
                 ds.add(arr[i]);
                 f(i + 1, arr, target - arr[i], ans, ds);
                 ds.remove(ds.size() - 1);
             }
         }
    }
    
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(arr);//  becoz we need sorted combinations
       f(0,arr,target,ans,new ArrayList<Integer>()); 
       return ans;
    }
}
