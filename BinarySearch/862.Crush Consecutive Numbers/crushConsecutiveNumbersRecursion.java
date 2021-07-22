// https://binarysearch.com/problems/Crush-Consecutive-Numbers
import java.util.*;

class Solution {
    HashMap<List<Integer>, Integer> memo;
    public int solve(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int i : nums) {
            numList.add(i);
        }
        memo = new HashMap<>();
        return recurse(numList, k);
    }

    private int recurse(List<Integer> nums, int k) {
        if (nums.size() == k) {
            return sumArray(nums);
        }
        if (nums.size() < k) {
            return -1;
        }
        if (memo.containsKey(nums)) {
            return memo.get(nums);
        }
        int n = nums.size();

        int i = 0;
        int j = 0;
        int currentSum = 0;
        int size = n - k + 1;
        int ans = Integer.MAX_VALUE;
        while (j < n) {
            currentSum += nums.get(j);
            if (j >= k - 1) {
                if (j >= k) {
                    currentSum -= nums.get(i - 1);
                }
                int m = j + 1;
                List<Integer> aux = new ArrayList<>();

                for (int a = 0; a < size; a++) {
                    if (a < i) {
                        aux.add(nums.get(a));
                    } else if (a > i) {
                        aux.add(nums.get(m++));

                    } else {
                        aux.add(currentSum);
                    }
                }

                int ret = recurse(aux, k);
                if (ret == -1)
                    return -1;
                ans = Math.min(ans, currentSum + ret);
                i++;
                j++;

            } else {
                j++;
            }
        }
        memo.put(nums, ans);

        return ans;
    }

    private int sumArray(List<Integer> a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}