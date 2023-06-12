import java.io.*;
import java.util.* ;

public class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        
     
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            // if first value is not equal sort it with first 
            // if it is sort with second val
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
             if(arr[i] + arr[j] == s){   
               int[] num = new int[2];
               if(arr[i] <= arr[j]){
                  num[0] = arr[i];
                  num[1] = arr[j];
               }else{
                  num[0] = arr[j];
                  num[1] = arr[i];
               }
               pq.add(num);
             }
            }
        }
        while(!pq.isEmpty()){
            int[] array = pq.poll();
            list.add(array);
        }
        return list;
    }
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
public class Solution {
    public static List<int[]> pairSum(int[] nums, int s) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i : nums) {
            int diff = s - i;
            if (mp.containsKey(diff)) {
                for (int k = 0; k < mp.get(diff); k++) {
                    list.add(new int[]{Math.min(i, diff), Math.max(i, diff)});
                }
            }
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        list.sort((a,b) -> {
           if(a[0] != b[0]){
               return Integer.compare(a[0],b[0]);
           }else{
               return Integer.compare(a[1],b[1]);
           }
        }); 

        return list;
    }
}

