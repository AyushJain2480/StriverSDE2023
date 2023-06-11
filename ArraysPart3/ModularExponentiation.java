import java.io.*;
import java.util.* ;

public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
       long res = 1;
       while(n > 0){
           // if it is odd store one x in res now if we are calculating 2^19
           // we store one 2 in res = 2 and now we will calcualte 2^18
           // like --> 4^9 we again store one 4 in res making res = 2 * 4
           // and calculate 4^8 we can write it like 16^2 --> (256 * 256)^1
           // so here also n is odd we store 256*256 in res making 
           // res = 2 * 4 * 256 * 256 now (256*256)^0 our ans is stored in res
           if(n % 2 == 1){
               res = (res * (long)(x % m)) % m;
               n--;
           }
           x = (int) (((long) (x % m) * (x % m)) % m);
           n = n / 2;
       }
       return (int)(res % m);
    }
}
