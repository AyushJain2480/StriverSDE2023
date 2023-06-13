import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String s){
        int i = 0;
        int j = 0;
        int max = 0;
        int strLen = s.length();
        
        HashSet<Character> hash_set = new HashSet<>();
        while(i < strLen && j < strLen){
        if(!hash_set.contains(s.charAt(j))){
            hash_set.add(s.charAt(j));
            j++;
            max = Math.max(hash_set.size(), max);
        }else{
            hash_set.remove(s.charAt(i));
            i++; 
        }
        }
        return max;
	}
}
