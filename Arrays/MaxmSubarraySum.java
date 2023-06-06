import java.util.* ;
import java.io.*; 

public class MaxmSubarraySum {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
	}
	public static long maxSubarraySum(int[] arr, int n) {
		long maxSum = 0;
        long sum = 0;
        for(int i = 0; i < n; i++){
			if(sum < 0){
				sum = 0;
			}
            sum += arr[i];
			maxSum = Math.max(sum , maxSum);
		}
		return maxSum;
  }
}
