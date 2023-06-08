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
