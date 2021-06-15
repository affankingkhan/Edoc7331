import java.util.HashMap;
import java.util.Collections;

class Solution {
    public List<Integer> nums;
    public int[] bins;
    public int possibleSquareSide;

    public Solution() {
        this.bins = new int[4];
    }

    // Depth First Search function.
    public boolean dfs(int index) {

        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == this.nums.size()) {
            return bins[0] == bins[1] && bins[1] == bins[2] && bins[2] == bins[3];
        }

        // Get current matchstick.
        int element = this.nums.get(index);

        // Try adding it to each of the 4 bins (if possible)
        for(int i = 0; i < 4; i++) {
            if (this.bins[i] + element <= this.possibleSquareSide) {
                this.bins[i] += element;
                if (this.dfs(index + 1)) return true;
                
                this.bins[i] -= element;
            }
        }

        return false;
    }

    public boolean makesquare(int[] nums) {
        // Empty matchsticks.
        if (nums == null || nums.length == 0) return false;

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += nums[i];
        }
        
        if(perimeter % 4 != 0) return false;

        this.possibleSquareSide =  perimeter / 4;

        // Convert the array of primitive int to ArrayList (for sorting).
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        return this.dfs(0);
    }
}