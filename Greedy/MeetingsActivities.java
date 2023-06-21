import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

// However, in the activity scheduling problem, we should compare 
// the end times instead. By sorting based on end times, we ensure
// that we select activities with earlier end times, allowing us 
// to schedule more activities.
public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        
    List<int[]> list = new ArrayList<>();

    for(int i = 0; i < start.size(); i++){
        list.add(new int[]{start.get(i),end.get(i)});
    }

    list.sort(Comparator.comparingInt(a -> a[1]));

    int endt = list.get(0)[1];
    int max = 1;
    for(int i = 1; i < list.size(); i++){
        if(endt <= list.get(i)[0]){
            endt = list.get(i)[1];
            max++;
        }
    }
    return max;
    }
}
