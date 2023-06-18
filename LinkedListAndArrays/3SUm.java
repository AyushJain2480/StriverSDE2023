// Brute force have time complexity of O(n3)


// O(N2) = O(nlogn) + O(n2) 
// For 10^5 testcases we can apply sorting mean it can accept the O(Nlogn) solution
HashSet<String> set = new HashSet<>();
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
           int j = i + 1;
           int k = n - 1;
           while(j < k){
               int sum = nums[i] + nums[j] + nums[k];
               if(sum == 0){
                   ArrayList<Integer> list = new ArrayList<>();
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(nums[k]);
                   String listString = Arrays.toString(list.toArray(new Integer[0]));
                   if(!set.contains(listString)){
                      res.add(list);
                      set.add(Arrays.toString(list.toArray(new Integer[0])));  
                   }
                   j++;k--;
               }else if(sum < 0){
                   j++;
               }else if(sum > 0){
                   k--;
               }
           } 
        }
        return res;

// 
