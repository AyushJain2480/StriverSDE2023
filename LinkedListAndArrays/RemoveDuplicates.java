import java.util.*;
public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int count = 1;
        if(arr.size() == 1){
			return 1;
		}
		for(int i = 1; i < n; i++){
			if(!arr.get(i).equals(arr.get(i - 1))){
				count++;
			}
		}
		return count;
	}
}
