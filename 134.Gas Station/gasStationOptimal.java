class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int start = 0, tank = 0, shortage = 0;
        for(int i = 0; i<length; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                shortage -= tank;
                tank = 0;
                start = i + 1;

            }
        }
        
        return (tank >= shortage) ? start : -1;
        
        
    }
}