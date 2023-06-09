
// Using extra space 

import java.io.*;
import java.util.* ;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(arr1[i] <= arr2[j]){
                res[k] = arr1[i];
                i++;
                k++;
            }else if(arr1[i] > arr2[j]){
                res[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i < m){
           res[k] = arr1[i];
           k++;
           i++;
        }

        while(j < n){
           res[k] = arr2[j];
           j++;
           k++;
        }
        return res;
    }
}


// without using extra space


public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;
        while(i >= 0 && j >= 0){
            arr1[k--] = (arr2[j] > arr1[i]) ? arr2[j--] : arr1[i--];
        }
        while(j >= 0){
           arr1[k--] = arr2[j--];
        }
        return arr1;
    }
}
