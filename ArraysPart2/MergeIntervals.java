import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new ArrayList<>();
        }

        // Sort the intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = intervals[i];

            // If the intervals overlap, merge them
            if (interval.start <= currentInterval.finish) {
                currentInterval.finish = Math.max(currentInterval.finish, interval.finish);
            } else {
                // Intervals don't overlap, add the current interval to the merged list
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }
}


// Leetcode - short and better 

class Solution {
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0])); // sort the array with start of interval
    
    ArrayList<int[]> list = new ArrayList<>();
    
    for(int[] interval : intervals){
        if(list.size() == 0){
            list.add(interval);
        }else{
            int[] prevInterval = list.get(list.size() - 1);
            if(prevInterval[1] >= interval[0]){  // if it is overlapping update the end 
                 prevInterval[1] = Math.max(prevInterval[1],interval[1]);
            }else{
                list.add(interval); // if not add 
            }
        }
    }
    return list.toArray(new int[list.size()][]);
    }
}
