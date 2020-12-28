class Solution {
    int[] original;

    public Solution(int[] nums) {
        this.original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = Arrays.copyOf(this.original, original.length);
        for(int i = 0;i<copy.length;i++){
            int range = copy.length - i;
            int rand = (int) (Math.random() * range) + i;
            int temp = copy[i];
            copy[i] = copy[rand];
            copy[rand] = temp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */