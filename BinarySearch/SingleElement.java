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
