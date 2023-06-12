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
