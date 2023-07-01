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
//  If k is significantly smaller than n, the min heap approach is generally more efficient. However, if k is close to n or comparable to n,
// the sorting approach may be more appropriate.
import java.util.*;
public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		// overall complexity -> O(nlogk)
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(Integer val : arr){
			minHeap.add(val); // take O(n)
		}
		int kthSmall = 0 , kthLarge = 0;
		int s = 1, l = n;

		while(!minHeap.isEmpty()){
			int pol = minHeap.poll(); // take O(logk)
			if(s == k || l == k){
				if(s == k){
					kthSmall = pol;
				}
				if(l == k){
					kthLarge = pol;
				}
				if(s > k && l < k){
					break;
				}
			}
			s++;
			l--;
		}
		list.add(kthSmall);
		list.add(kthLarge);
        return list;
	}
}

