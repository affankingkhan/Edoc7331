https://leetcode.com/problems/swim-in-rising-water/
//Dijkstra's Algorithm
class Solution {
    private int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int ans = grid[0][0];
        
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = 1;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            ans = Math.max(ans, curr[2]);
            if(curr[0] == n-1 && curr[1] == n-1) break;
            
            for(int[] m : moves){
                int i = curr[0] + m[0];
                int j = curr[1] + m[1];
                if(i < 0 || i >= n || j < 0 || j >= n || visited[i][j] == 1) continue;
                visited[i][j] = 1;
                pq.offer(new int[]{i,j,grid[i][j]});
            }
        }
        return ans;
    }
}
