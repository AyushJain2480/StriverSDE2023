public static int singleNonDuplicate(ArrayList<Integer> arr)
    { 
        if(arr.size() == 1)return arr.get(0);

        for(int i = 0; i < arr.size(); i++){
            if(i == 0){
               if(arr.get(i) != arr.get(i + 1)){
                   return arr.get(i);
               }
            }else if(i == arr.size() - 1){
               if(arr.get(i) != arr.get(i - 1)){
                   return arr.get(i);
               }
            }else{
               if(arr.get(i) != arr.get(i + 1) && arr.get(i) != arr.get(i - 1)){
                   return arr.get(i);
               }
            }
        }
        return -1;
    }



import java.util.ArrayList;
public class Solution
{
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        int n = arr.size();
        // Edge case
        if(n == 1) return arr.get(0);

        for(int i = n - 1; i >= 0; i-=2){
            if(i == 0 || arr.get(i) != arr.get(i - 1)){
                return arr.get(i);
            } 
        }
        return -1;
        
    }
}


return arr.stream().reduce(0, (a,b) -> (a^b));




// Better and optimised approach using binary search 
// this is working on both leetcode and coding ninjas

class Solution{
    public int singleNonDuplicate(int[] arr){
    int n=arr.length;

    if(n==1)return arr[0];

    if(arr[0]!=arr[1])return arr[0];

    if(arr[n-1]!=arr[n-2])return arr[n-1];

    int low=1,high=n-2;

    while(low<=high){

        int mid=low+(high-low)/2;

        if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1])return arr[mid];

        if((mid%2==1 && arr[mid-1]==arr[mid]) || (mid%2==0 && arr[mid]==arr[mid+1])){
            low=mid+1;
        }else{
            high=mid-1;
        }
    }
    return -1;
    }
}
