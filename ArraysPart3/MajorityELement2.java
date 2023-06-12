
// O(n) space O(n) time
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > n/3){
                res.add(key);
            }
        }
        return res;
    }
}
// Better approach using moore - O(1) space and O(n) time 
import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        int n = arr.size();
        ArrayList<Integer> res = new ArrayList<>();
        int val1 = arr.get(0);
        int count1 = 1;
        
        int val2 = arr.get(0); // assign any random values
        int count2 = 0;
        
        for(int i = 1; i < n; i++){
            if(arr.get(i) == val1){
                 count1++;
            }else if(arr.get(i) == val2){
                 count2++;
            }else{
                if(count1 == 0){
                    val1 = arr.get(i);
                    count1 = 1;
                }else if(count2 == 0){
                    val2 = arr.get(i);
                    count2 = 1;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        // val1 and val2 are the potential candidates
        // lets check there freq if it is > n/3 our assumption will be correct
        int c1 = 0;
        int c2 = 0;
        for(Integer num : arr){
            if(num == val1)c1++;
            else if(num == val2)c2++;
        }
        if(c1 > n/3){
            res.add(val1);
        }
        if(c2 > n/3){
            res.add(val2);
        }
        return res;
    }
}
