class Solution {
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        return findZero(arr,start,arr.length);
        
        
    }
    
    private boolean findZero(int[]arr, int i, int n ){
        if(i >= n || i < 0 || visited[i]) return false;
        if(arr[i] == 0) return true;
        visited[i] = true;
        
        boolean left = findZero(arr, i - arr[i], n);
        boolean right = findZero(arr, i + arr[i], n);
        
        return left || right;
        
    }
}