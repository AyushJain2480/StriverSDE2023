import java.util.*;
import java.util.ArrayList;
public class Solution 
{
    static  ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
       findSubsetsSumToK(0, 0,new ArrayList<Integer>(),arr, k, n);
       return subsets;
    }

    public static void findSubsetsSumToK(int ind, int sum,ArrayList<Integer> curr,ArrayList<Integer> arr, int k, int n){
        if(ind == n){
           if(sum == k){
               subsets.add(new ArrayList<Integer>(curr));
           }
           return;
        } 
       curr.add(arr.get(ind));
       findSubsetsSumToK(ind + 1, sum + arr.get(ind),curr, arr, k, n);
       curr.remove(curr.size() - 1);
       findSubsetsSumToK(ind + 1, sum ,curr,arr,k,n);
    }
}
