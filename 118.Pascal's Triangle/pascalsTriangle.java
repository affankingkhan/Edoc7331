https://leetcode.com/problems/pascals-triangle/
class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> generate(int numRows) {
        
        ret = new ArrayList<>();
        
        for(int i = 1; i<=numRows; i++){
            if(i <= 2){
                ret.add(fetchRow(i,null));
            }else{
                ret.add(fetchRow(i, ret.get(i-2)));
            }
        
        }
        
        return ret;
        
    }
    
    private List<Integer> fetchRow(int n, List<Integer> prevRow){
        List<Integer> list = new ArrayList<>();
        if(n <= 2){
            list.add(1);
            if(n == 2){
                list.add(1);
            }
            return list;
        }

        
        for(int i = 0; i< n; i++){
            if(i == 0 || i == n - 1){
                list.add(1);
            }else{
                list.add(prevRow.get(i-1)  + prevRow.get(i));
            }
        }
        
        return list;
    }
    
    
}