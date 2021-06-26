//https://leetcode.com/problems/redundant-connection/
class Solution {
    int[] parent;
    int[]rank;
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        Arrays.fill(rank, 1);
        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            if(!union(edge[0], edge[1])) return edge;
        }
        
        return edges[n-1];
        
  
    }
    
    private int find(int n){
        n = parent[n];
        while(n != parent[n]){
            n = parent[n];
        }
        return n;
    }
    
    private boolean union(int n1, int n2){
        int rep1 = find(n1);
        int rep2 = find(n2);
        
        if(rep1 == rep2) return false;
        
        if(rank[rep1] >= rank[rep2]){
            parent[rep2] = rep1;
            rank[rep1] += rank[rep2];
        }else{
            parent[rep1] = rep2;
            rank[rep2] += rank[rep1];
        }
        return true;
        
    }
}