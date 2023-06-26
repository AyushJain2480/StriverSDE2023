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
	  Collections.sort(list);
		int i = 0;
		int j = list.size() - 1;
		int m = (i + j)/2;
		return list.get(m);
	}
}
