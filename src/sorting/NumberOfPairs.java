package sorting;
import java.util.Arrays;
public class NumberOfPairs {
    public static void main(String[] args) {

    }
//    Intuition:
//
//    We are using the principle of if (x < y) then (x^y > y^x) leaving some exceptional cases including 0,1,2,3,
//    so we are keeping track of the frequency of 0,1,2,3 appearing in Y and
//    the rest elements are computed by the above-defined rule.
//    Implementation:
//
//    First count the frequency of 0,1,2,3,4 in array Y and store in another array.
//    Sort array Y[].
//    For every x in X[], find the index idx of the smallest number greater than x (also called ceil of x) in Y[] using binary search, or we can use the inbuilt function upper_bound() in the algorithm library.
//    All the numbers after idx satisfy the relation so just add (n-idx) to the count.
//    Finally return the count.
//
//    Note: In the above lemma some exceptions are there:-
//
//            if x = 0 return 0 there can't be any value in Y.
//            if x = 1 then return the frequency of zero in Y.
//            if x > 1 then return the sum of the frequency of 0 and 1 in Y.
//            if x = 2 then subtract the exception where y = 2 or y = 4.
//    if x = 3 then add the exception where y = 2 as 3^2 > 2^3.




    // x[], y[]: input array elements
    // M, N: size of arrays x[] and y[] respectively
    //Function to count number of pairs such that x^y is greater than y^x.
    static long countPairs(int x[], int y[], int M, int N)
    {
       /*
            if x < y, then for all x > 3, x^y > y^x

       */

        int[] count = new int[5];
        for(int i = 0; i < N; i++){
            if(y[i] < 5){
                count[y[i]]++;
            }

        }

        Arrays.sort(y);
        long pairs = 0;

        for(int i = 0; i < M; i++){

            //If x[i] is 0, then there can't be any value in y[]
            //such that x[i]^y[val]>y[val]^x[i].
            if(x[i] == 0) continue;

            //If x[i] is 1, then the number of pair is equal to
            //number of zeroes in y[]
            if(x[i] == 1){
                pairs += (long)count[0];
                continue;
            }

            //We work with logic that if x<y then x^y is greater than y^x.
            //Finding number of elements in y[] with value greater than x.
            //upper_bound() gets address of first element greater than x[i] in y[].

            int index = upper_bound(y, x[i]);
            //Updating number of pairs.
            //If we have reached here, then x must be greater than 1.
            //Increasing number of pairs for y=0 and y=1 .

            pairs += (long)(N - index) + (long)count[0] + (long)count[1];

            // decreasing the number of pairs for exception when x =2, and y = 4 or y = 3
            if(x[i] == 2){
                pairs = pairs - (long)count[3] - (long)count[4];
            }

            //increasing the number of pairs where x = 3 and y = 2

            if(x[i] == 3){
                pairs += (long)count[2];
            }

        }
        return pairs;



    }
    // The upper bound will give us the iterator pointing to the first element
    // greater than the value passed as a parameter.
    public static int upper_bound(int[] arr, int ele){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >ele){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }


}
