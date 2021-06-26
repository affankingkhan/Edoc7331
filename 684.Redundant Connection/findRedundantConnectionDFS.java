//https://leetcode.com/problems/redundant-connection/
class Solution {
    int MAX_NODES = 1000;
    ArrayList<Integer>[] graph;
    HashSet<Integer> visited;
    public int[] findRedundantConnection(int[][] edges) {
        // this will be used to make sure we don't traverse the same nodes
        visited = new HashSet<>();
        
        // graph is an array of lists
        // each index represents a vertex
        // each sublist for an index u represent all the node that are connected to u
        graph = new ArrayList[MAX_NODES + 1];
        for (int i = 0; i <= MAX_NODES; i++) {
            graph[i] = new ArrayList();
        }
        // Arrays.fill(graph, new ArrayList<>());
        
        int n = edges.length;
        
        // for each edge u-v we will check if there is already a path from u to v using dfs
        for(int[] edge : edges){
            visited.clear();
            int u = edge[0];
            int v = edge[1];
            // if there exists a path from u to v, then this edge is redundant.
            // so we return in
            if(!graph[u].isEmpty() && !graph[v].isEmpty() && dfs(u,v)){
                return edge;
            }
            
            // if there is no path from u to v, then it is safe to add to graph
            
            graph[u].add(v);
            graph[v].add(u);

        }
        
        // if input is valid, we will never reach this so jsut return something
        return edges[n-1];

    }
    
    
    // method determines if there is a path from start to end in the graph 
    private boolean dfs(int start,int end){
        //if we have already visited start, don't need to traverse it since
        //another recursive call is dealing with it
        if(visited.contains(start)) return false;
        
        // if we reach end, we know there is a path so return true
        if(start == end) return true;
        visited.add(start);
        
        // traverse all the direct connections of start
        for(int i : graph[start]){
            if(dfs(i, end)){
                return true;
            }
        }
        return false;
        
    }
    
    
    
    
    
    
    
    
    
}