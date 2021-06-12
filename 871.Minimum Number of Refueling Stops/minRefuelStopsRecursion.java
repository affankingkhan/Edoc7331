class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int val = minFuel(stations, 0, target,startFuel, 0, 0);
        
        if(val == Integer.MAX_VALUE){
            return -1;
        }
        return val;
    }
    
    
    private int minFuel(int[][]stations, int currStation, int target, int totalFuel, int stopCount, int currDistance){
        // if our current destination is the end
        if(currStation == stations.length){
            int distanceLeft = target - currDistance;
            if(totalFuel >= distanceLeft){
                return stopCount;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        
        // check if we can get to the next stop, if we can't return MAX VALU
        if(stations[currStation][0] - currDistance > totalFuel ){
            return Integer.MAX_VALUE;
        }
        
        //travel to the next stations
        
        totalFuel -= ( stations[currStation][0] - currDistance);
        
        // recursively check by taking gas and not taking gas at each station
        
        int take = minFuel(stations, currStation + 1, target, totalFuel + stations[currStation][1], stopCount+1, stations[currStation][0] );
        int notTake = minFuel(stations, currStation + 1, target, totalFuel, stopCount, stations[currStation][0] );
        
        return Math.min(take, notTake);
        
        
    }
}