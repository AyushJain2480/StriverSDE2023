class Solution {
    public List<String> wordBreak(String s, List<String> dictionary) {
     HashSet<String> dict = new HashSet<>();
	 for(String str : dictionary){
		 dict.add(str);
	 }
	 List<String> output = new ArrayList<>();
	 wordBreak(s,"",dict,output);
	 return output;
    }
    
    public  void wordBreak(String s, String curr, HashSet<String>dict, List<String> output){
     if(s.length() == 0){
        curr = curr.trim(); 
        output.add(curr);
		return;
	 }
	 for(int i = 0; i < s.length(); i++){
		String left = s.substring(0,i + 1);
		if(dict.contains(left)){
			String right = s.substring(i + 1);
            wordBreak(right, curr + left + " ",dict, output);
		}
	}
}
}
