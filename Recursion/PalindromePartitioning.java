import java.util.* ;
import java.io.*; 
public class Solution {
    public static void f(int ind, String s, List<String> ds, List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = ind; i < s.length(); i++){
            if(isPal(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                f(i + 1, s, ds, res);
                ds.remove(ds.size() - 1);
            }
        }
    }
    static boolean isPal(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        f(0, s, new ArrayList<>(), res);
        return res;
    }
}
