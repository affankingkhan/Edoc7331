class Solution {
    
    List<List<Integer>> ret; 
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        ret = new ArrayList<>();
        
        List<Integer> init = new ArrayList<>();
        init.add(0);
        dfs(graph, init, 0,n);
        return ret;
        
        
    }
    
    private void dfs(int[][] graph, List<Integer> currList, int currNode, int n){
        if(currNode == n){
            ret.add(new ArrayList(currList));
        }
        
        int[] subArray = graph[currNode];
        for(int i = 0; i<subArray.length; i++){
            // make decision
            currList.add(subArray[i]);
            // recursive call
            dfs(graph, currList, subArray[i], n);
            // back-track
            currList.remove(currList.size() - 1);
            
        }
    }
}