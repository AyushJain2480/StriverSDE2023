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
