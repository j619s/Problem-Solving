package LeetcodeDailyMarch2024;
    
public class FindMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        boolean oneFound = false;
        for(int j : nums){
            if(j == 1){
                oneFound = true;
                break;
            }
        }

        if(oneFound){
            int len = nums.length;
            for(int i = 0; i < len; i++){
                if(nums[i] <= 0 || nums[i] > len){
                    nums[i] = 1;
                }
            }

            for(int i = 0; i < len; i++){
                int pos = Math.abs(nums[i]) - 1;
                nums[pos] = -Math.abs(nums[pos]);
            }

            for(int i = 0; i < len; i++){
                if(nums[i] > 0){
                    return i + 1;
                }
            }

            return len + 1;
        } else {
            return 1;
        }

    }
}
/*
* The basic idea is that we have an array with n cells (n is the length of the array).
* The problem description first missing positive integer. If a positive integer is not in the given array it,
* the missing integer must be in the range [1..n]. This is the crucial observation we use to deduce the algorithm.

So, If an integer is missing it must be in the range [1..n], if an integer is not missing then the answer is n+1.

I'll try my best to explain why.

Let's picture the only two possibilities:

    There is no missing integer in the array
    There is a missing integer in the array.

If there is no missing integers, this means that the array has all number from 1 to n.
* This must mean that the array is full. Why, because in the range [1..n] there are exactly n numbers,
* and if you place n numbers in an array of length n, the array is by definition full. (in this case the solution is to return n+1 which is the first smallest integer).

Once you understand the first case above understanding the second is easy.
* If there is a missing integer (or more than one), the missing integer(s), let's call it X, must be in the range 1..n.
* Why, because if the missing integer X is not in the range [1..n] that would imply that all integers [1..n] are in the array,
* which would mean that the array is full, leaving no space to place X (since X is not in the range [1..n]).

Then the algorithm becomes:

    Ignore all numbers <=0 and >n since they are outside the range of possible answers (which we proved was [1..n]). We do this by replacing them with the value n+1.
    For all other integers <n+1, mark their bucket (cell) to indicate the integer exists. (*see below)
    Find the first cell not marked, that is the first missing integer. If you did not find an unmarked cell, there was no missing integer, so return n+1.

*I recommend looking at this solution for a very smart way to mark the cells:

https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation

[Note: I find the use of the words first missing integer misleading. For example in the array [0,1,2] there is no missing integer.
* What the question really asks is to return the smallest positive integer that is not in the array]
* */

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*

If we have an array of length n we know "smallest missing positive integer" must be in between 1 and n+1(inclusive).

For example:
[3,1,2,8,9] in this case we have an array of length n=5, so our smallest missing positive integer must lie between 1 and 5+1 = 6(inclusive).

Clearly, those values that are greater than n(5) should not be in here. Because if we have any value greater than n those values are occupying some smaller values place. For example, 8 is occupying index 3 where we should have either 4 or 5 and also 9 is occupying index 4 where we should have either 5 or 4.

The same goes for any value less than or equal to 0.

For example:
[-1,-2,3,1,2]
-1 is at index 0 where we should either 4 or 5, the same is true for -2 as well.

So, values that are >n and <=0 are all garbage. We don't need those.

Let's modify the array:
[3,1,2,8,9] will become [3,1,2,1,1]
[-1,-2,3,1,2] will become [1,1,3,1,2]

Why are we putting 1 in place of those values?

We know that, 1 is the smallest positive integer from 1 to infinity.

So if our array does not contain 1 then we know for sure that 1 is going to be the answer. There is no point checking further.

But, if we do have 1 as an item inside the array then some other value[ >1 && <=n ] inside the array which is missing will be the answer. If none are missing then n+1 will be the answer.

With that in mind when we see any garbage value that should not be in this array we replace that value with 1, which we already knew is present in the array. Between garbage value and 1, only 1 is allowed to be present in our modified array.

Once we are done processing our array, we know all the values inside the array should lie between 1 & n(inclusive).

One more processing needs to happen before we look for the answer.
As an easier example, let's say after processing up till this point we got an array like this:
[1,2,3,3]
In an ideal case we should have had [1,2,3,4], if all the values were present. Now in this case which one is not present? How can you tell?
If we take each value of each index and update the corresponding value to it's negative then we will have an array like this [-1,-2,-3,3].
How? Take i=2, update whatever is present to negative:

*/