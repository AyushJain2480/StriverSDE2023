import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> prefixXorFreq = new HashMap<>();
        
        prefixXorFreq.put(0, 1); // Add initial prefix XOR value
		for(Integer  num : arr){
             xor ^= num; // Update XOR value
            
            // Calculate the required XOR value to satisfy the condition
            int requiredXor = xor ^ x;
            
            // Check if the required XOR value exists in the prefix XOR frequencies
            if (prefixXorFreq.containsKey(requiredXor)) {
                count += prefixXorFreq.get(requiredXor);
            }
            
            // Update the prefix XOR frequencies
            prefixXorFreq.put(xor, prefixXorFreq.getOrDefault(xor, 0) + 1);
		}
		return count;
	}
}
