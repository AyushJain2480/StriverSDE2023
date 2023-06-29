import java.util.* ;
import java.io.*; 
public class Solution {

    public static int chessTournament(int[] A, int n,  int m) 
	{
       if(A.length < m) return -1; 
       Arrays.sort(A);
      
       int hi = A[n - 1] - A[0]; // maxm dist b/w cows -> max - min
       int lo = 1; // minm dist b/w cows -> 1
       
       int ans = -1;
       while(lo <= hi){
           int mid = lo + (hi - lo) / 2;
           int count = 1; // first cow is placed at A[0]
           int last = A[0]; 
           for(int i = 1; i < n; i++){ // start from 2nd cow
              // check if minm dist is maintained
              if(A[i] - last >= mid){
                  count++; // inc count of cows 
                  last = A[i]; // assign new location new dist for next cow
              }
           }
           if(count >= m){
               ans = mid; // if we got the ans we want maxm in previous question 
               // book allocation we want minm i.e why in this line there is change
               lo = mid + 1;
           }
           else{
               hi = mid - 1;
           } 
       }
       return ans;
    }
}

 
