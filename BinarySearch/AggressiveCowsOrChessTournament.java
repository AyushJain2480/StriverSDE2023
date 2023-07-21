// O(max - min) * O(n) ---> quadritic time complexity
// O(1) 
import java.util.*;
public class Solution {
    public static int aggressiveCows(int[] A, int cows) {
       Arrays.sort(A);
       int min = A[0];
       int max = A[A.length - 1];
       // checking min dist possible
       // max - min is possible max ans means maxm distance possible b/w 2 cows
       int i = 1;
       for(;i <= max - min; i++){
           if(canWePlace(A,cows,i)){
               continue;
           }
           return i - 1; // maxm min distance b/w cows
       }
       return i - 1;
    }

    public static boolean canWePlace(int[] A, int cows , int dist){
        // first cow must be at 0th pos 
        int cowsPlaced = 1, lastCow = A[0];

        // placing other cows
        for(int i = 1; i < A.length; i++){
            if(A[i] - lastCow >= dist){
                cowsPlaced++;
                lastCow = A[i];
            }
            if(cowsPlaced >= cows) return true;
        }
        return false;
    }
}

// optimised..

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

 
