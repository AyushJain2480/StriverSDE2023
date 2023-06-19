
// 1st variation
// To find whether it is possible to attend all the meetings or not.

public class Main{
    public static boolean meetingRooms(int intervals[][]){
// sorting by start interval so that we don't have to handle permutations
    Arrays.sort(intervals, Integer.compare(a[0],b[0]));
    
    int ep = intervals[0][1];
    
    for(int i = 1; i < intervals.length; i++){
        if(intervals[i][0] >= ep){
            ep = intervals[i][1];
        }else{
            return false; // Violation 
        }
    }
    return true; // means there is no violation.
    }
}


// 2nd variation
// Question is Find the minimum number of conference rooms required so that all meetings can be done.

public class Solution {
    public int solve(int[][] intervals) {
    // sort on the basis of start
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
    // storing end time in min heap
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for(int[] interval : intervals){
        if(pq.size() == 0){
            pq.add(interval[1]);
        }
        else{
            if(interval[0] >= pq.peek()){
            pq.remove();
            pq.add(interval[1]);// old room has been occupied
            }else{
                pq.add(interval[1]); // creating a new room
            }   
        }
    }
    return pq.size(); // denotes the no. of rooms required
    }
}


