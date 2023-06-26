// o(N)
for(int i = 1; i <= m; i++){
            if(Math.pow(i,n) == m){
               return i;
            }
 }
 return -1;


public class Solution {
    public static int NthRoot(int n, int m) {
        // we try to find the integer whose n times mulitplication 
        // is equal to m in a search space 
        // we will decrease the search space acc to that
        // if there is no integer possible we return -1
       // O(log(n + m))
        
        int s = 1;
        int e = m;
        while(s <= e){
           int mid = (s + e)/2;
           int prod = (int)Math.pow(mid,n);
           if(prod == m){
               return mid;
           }else if(prod > m){
               e = mid - 1;
           }else {
               s = mid + 1;
           }
        }
        return -1;
    }
}
