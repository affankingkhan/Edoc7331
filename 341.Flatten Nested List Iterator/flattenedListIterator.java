/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int size;
    int i;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        this.size = 0;
        this.i = 0;
        ListLoader(nestedList);
        
    }
    
    private void ListLoader (List<NestedInteger> nestedList){
        for(NestedInteger elem : nestedList){
            if(elem.isInteger()){
                list.add(elem.getInteger());
                size++;
            }else{
                ListLoader(elem.getList());
            }
        }
    }

    @Override
    public Integer next() {
        int ret = this.list.get(i);
        i++;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return this.i < this.size;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */