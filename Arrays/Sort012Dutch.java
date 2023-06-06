import java.util.* ;
import java.io.*; 
public class Sort012Dutch
{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-- > 0){
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i]  = sc.nextInt();
            }
            sort012(arr);
        }
    }
    // Dutch National Flag Problem 
    public static void sort012(int[] arr)
    {
      int start = 0;
      int end = arr.length - 1;
      int mid = 0;
      while(mid <= end){
          if(arr[mid] == 0){
            swap(arr,start,mid);
            start++;mid++;
          }else if(arr[mid] == 1){
            mid++;
          }else if(arr[mid] == 2){
            swap(arr,mid,end);
            end--;
          }
      }
    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
