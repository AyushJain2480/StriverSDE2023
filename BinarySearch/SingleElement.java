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

 public static int singleNonDuplicate(ArrayList<Integer> arr)
    { 
        int n = arr.size();
        if(n == 1) return arr.get(0);
        if(arr.get(0) != arr.get(1)) return arr.get(0);
        if(arr.get(n - 1) != arr.get(n - 2)) return arr.get(n - 1);


        int lo = 1;
        int hi = n - 2;

        while(lo <= hi){
           int mid = (lo + hi) / 2;
           if(arr.get(mid) != arr.get(mid - 1) && arr.get(mid) != arr.get(mid + 1)){
               return arr.get(mid);
           }
           if(mid % 2 == 0){
                if(arr.get(mid) == arr.get(mid + 1)){
                    hi = mid - 1;
                }else if(arr.get(mid) == arr.get(mid - 1)){
                    lo = mid + 1;
                }
           }else{
               if(arr.get(mid) == arr.get(mid - 1)){
                   lo = mid + 1;
               }else if(arr.get(mid) == arr.get(mid + 1)){
                   hi = mid - 1;
               }
           }
        }
        return -1;
    }
