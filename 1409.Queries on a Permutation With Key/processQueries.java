class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        int[] ret = new int[queries.length];
        
        for(int i = 1; i <= m; i++){
            list.add(i);
        }
        
        for(int i = 0; i< queries.length; i++){
            int num = queries[i];
            int index = list.indexOf(num);
            ret[i] = index;
            list.remove(index);
            list.add(0, num);
        }
        
        return ret;
        
    }
}