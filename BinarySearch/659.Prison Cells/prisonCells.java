// https://binarysearch.com/problems/Prison-Cells
import java.util.*;

class Solution {
    public int[] solve(int[] nums, int k) {
        int n = nums.length;
        // convert the current array nums to a string
        String curr = "";
        for (int i = 0; i < n; i++) {
            curr += nums[i];
        }

        // list will add all the unique states we have come across in order
        ArrayList<String> list = new ArrayList<>();
        // map will map the string to the index in list
        HashMap<String, Integer> map = new HashMap<>();

        // add the current string to the list and map
        list.add(curr);
        map.put(curr, 0);

        // while k is greater than 0 we, compute the next state
        while (k > 0) {
            StringBuilder sb = new StringBuilder("0");
            for (int i = 1; i < n; i++) {
                if (i == n - 1) {
                    sb.append("0");
                } else {
                    if (curr.charAt(i - 1) == curr.charAt(i + 1))
                        sb.append("1");
                    else {
                        sb.append("0");
                    }
                }
            }

            // set curr to the next state

            curr = sb.toString();

            // if map contains this new state as a key, we have come across it before so it is the
            // start of a pattern for this reason we break;
            if (map.containsKey(curr)) {
                break;
            }
            // if this is a unseen state, we add it to the list and map an decrement k
            k--;
            list.add(curr);

            map.put(curr, list.size() - 1);
        }

        // if we exited the while loop due to k reaching 0, we convert the current state to the
        // int[] and return
        if (k == 0)
            return convertStringToIntArr(curr);

        // if we exited becuase we found a repeat state, the state will have been set to the repeat
        // state we get the index in the list of when this state occurs the pattern will repeat from
        // this index to the end of the list and loop around.
        int idx = map.get(curr);
        int end = list.size() - 1;
        // count stores how many states are in the pattern
        int count = end - idx + 1;

        // the index of the kth state will be compute using modulo
        int retIdx = idx + ((k - 1) % count);
        // conver the string to an int arr and return
        return convertStringToIntArr(list.get(retIdx));
    }

    private int[] convertStringToIntArr(String str) {
        int n = str.length();

        int[] ret = new int[n];

        char[] ch = str.toCharArray();

        for (int i = 0; i < n; i++) {
            ret[i] = ch[i] - '0';
        }

        return ret;
    }
}