#include <bits/stdc++.h>

void rec(vector<int> &nums, int sum, int idx, int n, vector<int> &ans)
{
    if (idx == n)
    {
        ans.push_back(sum);
        return;
    }

    rec(nums, sum + nums[idx], idx + 1, n, ans);
    rec(nums, sum, idx + 1, n, ans);
}

vector<int> subsetSum(vector<int> &num)
{
    // Write your code here.
    vector<int> ans;
    int n = num.size();
    rec(num, 0, 0, n, ans);

    sort(ans.begin(), ans.end());
    return ans;
}




// java 


import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static ArrayList<Integer> subsetSum(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();
        f(0, 0, num, list);
        Collections.sort(list);
        return list;
    }

    public static void f(int i, int sum, int[] num, ArrayList<Integer> list) {
        // base case
        if (i == num.length) {
            list.add(sum); // add the subset sum into the list;
            return;
        }
        // left recursion
        f(i + 1, sum + num[i], num, list);
        // right recursion
        f(i + 1, sum, num, list);
    }
}
