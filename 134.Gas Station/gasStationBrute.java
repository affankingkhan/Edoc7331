class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        
        for(int i = 0; i<length; i++){
            int tank = 0;
            int j = i;
            int stationsChecked = 0;
            while(stationsChecked < length){
                tank += gas[j % length] - cost[j % length];
                if(tank < 0){
                    break;
                }
                stationsChecked++;
                j++;
            }
            if(stationsChecked == length){
                return i;
            }
            
            
        }
        return -1;
    }
}