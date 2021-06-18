https://leetcode.com/problems/range-sum-query-mutable/
class NumArray {

    int[] tree;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        // just set the length of the array to 2X the nums
        
        
        this.tree = new int[4 * n];
        this.buildTree(nums, 0, 0, n-1);
    }
    
    
    // similar to heap, divide the array into 2 and add the left and right sums to the current index
    private int buildTree(int[] nums, int parentIndex, int l, int r) {
        if(l == r){
            this.tree[parentIndex] = nums[l];
            return nums[l];
        }
        
        int mid = (l + r) / 2;
        
        this.tree[parentIndex] = buildTree(nums,2 * parentIndex + 1, l, mid) + buildTree(nums,2 * parentIndex + 2, mid+1, r);
        return tree[parentIndex];
    }
    
    public void update(int index, int val) {
        updateTree(0, index,val,0,n-1); 
    }
    
    private int updateTree(int parentIndex, int index, int val, int l, int r){
        if(l == r){
            int diff = val - this.tree[parentIndex];
            this.tree[parentIndex] = val;
            return diff;
        }
        
        int m = (l + r) / 2; 
        
        int diff;
        if(index <= m){
            diff = updateTree(2*parentIndex +1, index, val, l, m);
            this.tree[parentIndex] += diff;
        }else{
            diff = updateTree(2*parentIndex +2, index, val, m+1, r);
            this.tree[parentIndex] += diff;
        }
        return diff;
    }
    
    public int sumRange(int left, int right) {
        return getSum(0,0,n-1,left,right);
    }
    
    private int getSum(int parentIndex, int l, int r, int left, int right){
        // no overlap, return 0
        if(r < left || l > right) return 0;
        
        // if the current l and r is full inside left and right, we return the value
        if(l >= left && r <= right) return this.tree[parentIndex];
        
        // if it paritally overlaps we have to go down deeper
        int m = (l + r) / 2;
        
        return getSum(2 * parentIndex + 1, l,m, left, right) + getSum(2 * parentIndex + 2, m+1,r, left, right);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */