import java.io.*;
import java.util.* ;

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
