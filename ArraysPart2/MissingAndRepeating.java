// In most of the solutions I have not changed the class name to File name becoz I m saving multiple possible solutions so 
// If any one is using the code keep in mind that filename and class name must be same than only it will work
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class MissingAndRepeating {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
       boolean[] store = new boolean[n + 1];
       int[] res = new int[2];

       for(int i = 0; i < arr.size(); i++){
           int index = arr.get(i);
           if(store[index]){
               res[1] = index;
           }else{
               store[index] = true;
           }
       }

       for(int i = 1; i < store.length; i++){
           if(store[i] == false){
               res[0] = i;
           }
       }
      return res;
    }
}
