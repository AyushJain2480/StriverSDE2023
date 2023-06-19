
// 1st variation
// This is the 1st variation of meeting rooms and question is 
// To find whether it is possible to attend all the meetings or not.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for(int i = 0 ; i <  n ; i++){
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}


// 2nd variation

