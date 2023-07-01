import java.util.*;
public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(arr);
		int kthSmallest = arr.get(k - 1);
        int kthLargest = arr.get(n - k);
		list.add(kthSmallest);
		list.add(kthLargest);
		return list;
	}
}
