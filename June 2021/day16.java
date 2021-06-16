class Solution {
    List<String> ret;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        recurse("", n, 0, 0);
        return ret;
        
        
        
    }
    
    private void recurse(String curr, int n, int left, int right){
        if(right > n || left > n) return;
        if(right > left) return;
        if(left == right && right == n){
            ret.add(curr);
            return;
        }
        
        recurse(curr + '(', n, left + 1, right);
        recurse(curr + ')', n, left, right + 1);
        return;
        
    }
}