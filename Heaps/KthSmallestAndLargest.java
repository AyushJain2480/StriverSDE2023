// THree ways we can solve this problem using sorting that wil take O(nlogn) time
// using Priority queue that will take O(nlogk) time 
// using quick select algo that will take O(n) time.
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
	// remove n elements k times --> O(nlogk)
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

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        
        return heap.peek();
    }
}

// FUll O(n) solution using quickselect kth largest and kth smalllest element

import java.util.*;
public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		Integer[] nums = arr.toArray(new Integer[0]);
        int kthLargest = findKthLargest(nums, k);
		int kthSmallest = findKthSmallest(nums, k);
        list.add(kthSmallest);
		list.add(kthLargest);
		return list;
	}
	public static int findKthLargest(Integer[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1; 
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }
	public static int findKthSmallest(Integer[] nums, int k) {
        int start = 0, end = nums.length - 1, index = k - 1;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1; 
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }
	public static int partion(Integer[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
}

