import java.util.*;
public class Solution {
    public static int search(int arr[], int key) {
        int n = arr.length;
        if(n == 1){
            if(arr[0] == key){
                return 0;
            }else{
                return -1;
            }
        }
        int i = 0;
        for(; i < n - 1; i++){
            if(arr[i] > arr[i + 1]){
                break;
            }
        }
        int left = Arrays.binarySearch(arr, 0, i + 1, key);
        int right = Arrays.binarySearch(arr, i + 1, n, key);
        if(left >= 0){
            return left;
        }
        if(right >= 0){
            return right;
        }
        return -1;
    }
}
