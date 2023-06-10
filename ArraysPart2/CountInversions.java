// Brute Force 
import java.util.* ;
import java.io.*; 
public class CountInversions{
    public static long getInversions(long arr[], int n) {
        long c = 0L;
        for(int i =0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i < j && arr[i] > arr[j]){
                   c++;
                }
            }
        }
        return c;
    }
}

// Count Inversion using merge Sort
import java.util.* ;
import java.io.*; 
public class Solution {
    static long count = 0;
    public static long getInversions(long arr[], int n) {
        mergeSort(arr,0,n-1);
        return count;
    }

    public static long[] mergeSort(long[] arr , int lo , int hi){
        if(lo == hi){
            long[] base = new long[1];
            base[0] = arr[lo];
            return base;
        }
        int mid = (lo + hi)/2;
        long[] left = mergeSort(arr,lo,mid);
        long[] right = mergeSort(arr,mid + 1,hi);
        long[] merged = merge(left,right);
        return merged;
    }
    
    public static long[] merge(long[] left, long[] right){
        int i =0;
        int j =0;
        int k =0;
        int l = left.length;
        int r = right.length;
        long[] res = new long[l + r];
        
        while(i < l && j < r){
            if(left[i] > right[j]){
                count += (l - i);
                res[k++] = right[j++];
            }
            else if(left[i] <= right[j]){
                res[k++] = left[i++];
            }
        }

        while(i < l){
            res[k++] = left[i++];
        }
        while(j < r){
            res[k++] = right[j++];
        }
        return res;
    }   
}
