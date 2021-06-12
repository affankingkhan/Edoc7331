class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        // max heap for all the unvisited stations, the one with the most gas is at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]- a[1]);
        
        int n = stations.length;
        int stationCount = 0;
        // set distance to the amount of startFuel initially
        int distance = startFuel;
        int furthestStation = -1;
        
        // populate the pq with all the stations we could have pontentially stopped at from traveleing from 0 to distance 
        // store the previously added station as we will need this to start the next round
        for(int i = 0; i< n; i++){
            if(stations[i][0] > distance) break;
            pq.offer(stations[i]);
            furthestStation = i;
        }
        
        // stationCount max value is n
        while(stationCount <= n){
            // if the current distance is already equal or greater than target, return stationCount
            if(distance >= target) return stationCount;
            
            // if there is are no more stations we can visit, return -1
            if(pq.peek() == null) return -1;
            
            // get the max gas stations and add the gas to the distance getting the new furthest distance
            int[] maxStation = pq.poll();
            distance += maxStation[1];
            
            // add all stations between (furthestStation, distance]
            for(int i = furthestStation + 1; i< n; i++){
                if(stations[i][0] > distance) break;
                pq.offer(stations[i]);
                furthestStation = i;
            }
            //increment stationCount since we have visited 1 more station
            stationCount++;
           
        }
        
        // return -1 if we have not reached the end
        
        return -1;
    }
}