import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		ArrayList<Integer> list= new ArrayList<>();
		for(ArrayList<Integer> arr : matrix){
			for(Integer ele : arr){
				list.add(ele);
			}
		}
				// List<Integer> list = matrix.stream().flatMap(List::stream).collect(Collectors.toList());

	  Collections.sort(list);
		int i = 0;
		int j = list.size() - 1;
		int m = (i + j)/2;
		return list.get(m);
	}
}



// Binary search because each row is sorted 
// find the elements less than <= mid = cnt
//  if cnt <= (n * m) / 2 --> low + 1 else hi - 1

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> A)
	{
		int lo = 1;
		int hi = 1000000000;
                int n = A.size();
		int m = A.get(0).size();

		while(lo <= hi){
			int mid = (lo + hi) / 2;
			int cnt = 0;
			for(int i = 0; i < n; i++){
				cnt += countSmallerThanMid(A.get(i), mid);
			}
			if(cnt <= (n * m)/2){
				lo = mid + 1;
			}else{
				hi = mid - 1;
			}
		}
		return lo;
	}

	public static int countSmallerThanMid(ArrayList<Integer> row , int mid){
		int lo = 0;
		int hi = row.size() - 1;
		while(lo <= hi){
			int md = (lo + hi)/2;
			if(row.get(md) <= mid){
                lo = md + 1;
			}else{
                hi = md - 1;
			}
		}
		return lo;
	}
}
