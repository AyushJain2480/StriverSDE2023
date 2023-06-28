public class Solution {
    public static int ninjaAndLadoos(int a[], int b[], int n, int m, int k) {
        if(a.length > b.length){
            int[] temp = a;
            a = b; 
            b = temp;
        }
        int lo = Math.max(0,k - m);
        int hi = Math.min(k, n); 
        
        while(lo <= hi){
            int aleft = (lo + hi) / 2;
            // If you have 13 elements make it 14 becoz we want 7 elements in the left thats why we added 1 in te
            int bleft = k - aleft;
            
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1];
            int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1];
            int bl = (bleft == b.length)? Integer.MAX_VALUE : b[bleft]; 
            
            // valid segregation 
            if(alm1 <= bl && blm1 <= al){
                return Math.max(alm1, blm1);
            }
            else if(alm1 > bl){
                // there are more elements to be picked in left part from which 'b' ar
                hi = aleft - 1;
            }else if(blm1 > al){ 
                // there are more elements to be picked in left part from which 'a' array
                lo = aleft + 1;
            }
        }
        return 1;
    }
}
