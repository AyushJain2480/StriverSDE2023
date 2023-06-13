import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        int max = 0;
		for(int i = 0; i < arr.size(); i++){
			int sum = 0;
			for(int j = i; j < arr.size(); j++){
               sum += arr.get(j);
			   if(sum == 0){
				   max = Math.max(max,j-i+1);
			   }
			}
		}
		return max;
	}
}


// optimised approach 


import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> a) {
		Map<Integer,Integer>map=new HashMap<>();
		int maxi = 0;
		int sum =0;

		for (int i = 0; i<a.size(); i++){
			sum+=a.get(i);
			if (sum==0){
				maxi= i+1;
			}
			else {
				if (map.containsKey(sum)){
					maxi= Math.max(maxi, i- map.get(sum));
				}
				else {
					map.put(sum,i);
				}
			}
		}
		return maxi;
	}
}
