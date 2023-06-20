import java.util.* ;
import java.io.*; 
/****************************************************************
        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
*****************************************************************/
// TC - O(nlogn) + O(n) = O(nlogn)
public class Solution {
    public static double maximumValue(Pair[] items, int n, int W) {
		Arrays.sort(items,(a,b) ->{
			double ratioA = (double) a.value/a.weight;
			double ratioB = (double) b.value/b.weight;
            return Double.compare(ratioB,ratioA);
		});

        int currWeight = 0;
		double finalValue = 0.0;

		for(int i = 0; i < n; i++){
            // If it doesn't exceed the knapsack we will put the object 
			if(currWeight + items[i].weight <= W){
                finalValue += items[i].value;
				currWeight += items[i].weight;
			}else{// If it exceed we will put the fraction
			    int remain = W - currWeight;
                finalValue += ((double)items[i].value / items[i].weight) * remain;
				break;
			}
		}
        return finalValue;
    }
}
