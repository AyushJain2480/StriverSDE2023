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
