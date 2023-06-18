// Brute force have time complexity of O(n3)


// O(N2) = O(nlogn) + O(n2) 
// For 10^5 testcases we can apply sorting mean it can accept the O(Nlogn) solution
HashSet<String> set = new HashSet<>();
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
           int j = i + 1;
           int k = n - 1;
           while(j < k){
               int sum = nums[i] + nums[j] + nums[k];
               if(sum == 0){
                   ArrayList<Integer> list = new ArrayList<>();
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(nums[k]);
                   String listString = Arrays.toString(list.toArray(new Integer[0]));
                   if(!set.contains(listString)){
                      res.add(list);
                      set.add(Arrays.toString(list.toArray(new Integer[0])));  
                   }
                   j++;k--;
               }else if(sum < 0){
                   j++;
               }else if(sum > 0){
                   k--;
               }
           } 
        }
        return res;

// accepted solution without hashset



import java.util.* ;
import java.io.*; 
public class Solution {

public static ArrayList<ArrayList<Integer>> findTriplets(int[] nums, int n, int target)  {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n - 2; i++){
           if(i == 0 || i > 0 && nums[i] != nums[i - 1]){  // For avoiding duplicates
           int j = i + 1;
           int k = n - 1;
           while(j < k){
               int sum = nums[i] + nums[j] + nums[k];
               if(sum == target){
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    res.add(triplet);
                   while(j < k && nums[j] == nums[j + 1]) j++; // For avoiding duplicates
                   while(j < k && nums[k] == nums[k - 1]) k--;
                   j++;k--;
               }else if(sum < target){
                   j++;
               }else
                   k--;
           }
           }
        }
        return res;
}
}

