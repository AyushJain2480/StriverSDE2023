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
