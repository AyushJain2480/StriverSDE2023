// using hashamp with O(n) space and O(N) time
import java.io.*;
import java.util.* ;

public class Solution {
	public static int findMajority(int[] arr, int n) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int num : arr){
			map.put(num,map.getOrDefault(num, 0) + 1);
		}
		for(int key : map.keySet()){
			if(map.get(key) > Math.floor(n/2)){
                return key;
			}
		}
		return -1;
	}
}

// Better approach with O(n)  time and O(1) space - Moore's voting 
import java.io.*;
import java.util.* ;

public class Solution {
	
	// 1,2,3,4,5,6,6,7,9,9
    // so all the elements are paired except last two 9 so they are potential candidate
	public static int findMajority(int[] nums, int n) {
	   // value have potential candidate for majority element 
       int value  = validCandidate(nums);
       // find frequency for potential candidate
        int count = 0;
        for(int num : nums){
            if(num == value){
                count++;
            }
        }
        if(count > nums.length/2){
           // majority element is value
            return value;
        }
        return -1;
	}

	public static int validCandidate(int[] nums){
        int val = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(val == nums[i]){
                // same element increment in freq
                count++;
            }else{
                // distinct element map it with val
                count--; 
            }
            if(count == 0){
                // setting new val so if in future we get same ele inc in freq and 
                // if distinct ele than map it with this val
                val = nums[i];
                count = 1;
            }
        }
        return val;
    }
}
