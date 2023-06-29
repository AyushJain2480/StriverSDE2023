import java.util.*;

public class Solution {
    public int books(int[] A, int m) {
       if(m > A.length) return -1; 
       int hi = 0;
       int lo = 0;
       for(int num : A){
           lo = Math.max(lo,num);
           hi += num;
       }
       
       int ans = -1;
       while(lo <= hi){
           int mid = lo + (hi - lo) / 2;
           int sum = 0;
           int st = 1;
           for(int i = 0; i < A.length; i++){
               sum += A[i];
               if(sum > mid){
                   st++;
                   sum = A[i];
               }
           }
           if(st <= m){
               ans = mid;
               hi = mid - 1;
           }
           else{
               lo = mid + 1;
           } 
       }
       return ans;
    }
}
