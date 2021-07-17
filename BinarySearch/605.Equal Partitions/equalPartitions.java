// https://binarysearch.com/problems/Equal-Partitions
import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        // if the sum is not divisible by 2, we know we can't have an equal partition
        if (sum % 2 != 0)
            return false;

        // this will be the sum of the 2 partition
        int partitionSum = sum / 2;

        // dp table where we dp[i][j] = the max sum possible considering all the elements up to i 
        // and the maximum sum up to j
        int[][] dp = new int[n + 1][partitionSum + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < partitionSum + 1; j++) {

                int capacity = j;
                int item = nums[i - 1];
                // if we choose not to add the number to the current parition
                int notTakeMax = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (item > capacity) {
                    dp[i][j] = notTakeMax;

                } 
                // if we choose to addd the current number to the partition
                else {
                    int other = capacity - item;
                    int rest = item + dp[i - 1][other];
                    dp[i][j] = Math.max(rest, notTakeMax);
                }
                if (dp[i][j] == partitionSum)
                    return true;
            }
        }

        // if the partition considering all the elements can have a sum of partitionSum we know the rest will have a 
        // sum of partitionSum. Thus the 2 partitions are equal.
        return dp[n][partitionSum] == partitionSum;
    }
}