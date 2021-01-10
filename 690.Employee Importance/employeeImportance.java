/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer,Employee> map = new HashMap<>();
        
        for(Employee employee : employees){
            map.put(employee.id, employee);
        }
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(id);
        
        int retValue = 0;
        
        while(stack.peek() != null){
            Employee empl = map.get(stack.pop());
            retValue += empl.importance;
            for(int subId : empl.subordinates){
                stack.push(subId);
            }
        }
        return retValue;
    }
}