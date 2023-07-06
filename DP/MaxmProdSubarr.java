import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		int maxProd = Integer.MIN_VALUE;
		int prod = 1;

		for(int i = 0; i < arr.size(); i++){
                        prod *= arr.get(i);
			maxProd = Math.max(maxProd,prod);
			if(prod == 0){
				prod = 1;
			}
		}
		prod = 1;
		for(int j = n - 1; j >= 0; j--){
			prod *= arr.get(j);
			maxProd = Math.max(maxProd,prod);
			if(prod == 0){
				prod = 1;
			}
		}
		return maxProd;
	}
}
