// passed in leetcode bruteforce O(2^n) - unique subsets 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> sub = new ArrayList<>(subsets.get(i));
                sub.add(num);
                subsets.add(sub);
            }
        }
        return subsets;
    }
}
