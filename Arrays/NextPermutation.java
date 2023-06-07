import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation 
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-- > 0){
			int size = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 0; i < size; i++){
				int val = sc.nextInt();
				list.add(val);
			}
			nextPermutation(list);
		}
	}
	public static void swap(Integer[] arr,int i, int j){
		Integer temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void reverse(Integer[] arr,int start , int end){
		while(start< end){
			swap(arr,start,end);
			start++;
			end--;
		}
	}
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> p) 
	{
		Integer[] arr = p.toArray(new Integer[0]);
		int n = arr.length;
		int i = n - 2;
		// Find the first pair of adjacent elements in descending order
		while(i >= 0 && arr[i] >= arr[i + 1]){
           i--;
		}
		if(i >= 0){
            int j = n - 1;
			// Find the first element greater than nums[i] from the right side
            while(j >= 0 && arr[i] >= arr[j]){
				j--;
			}  
	        swap(arr,i,j);
		}
		// Reverse the subarray starting from i+1 to the end
		reverse(arr, i + 1, n - 1);
		return new ArrayList<>(Arrays.asList(arr));
	}
}
