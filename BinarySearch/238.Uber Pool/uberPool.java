// https://binarysearch.com/problems/Uber-Pool
import java.util.*;

class Solution {
    public boolean solve(int[][] trips, int capacity) {
        // sort the trips by start time
        Arrays.sort(trips, (a, b) -> a[0] - b[0]);

        // this is the current cappacity
        int cur = 0;
        // PQ will store the trips that are currently in the uber
        // The top one has the earliest leave time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < trips.length; i++) {
            // while there are passengers, unload the ones that end at or before the current trip
            // decrement curr accordingly
            while (pq.size() > 0 && pq.peek()[1] <= trips[i][0]) {
                int top[] = pq.poll();
                cur -= top[2];
            }

            // add the current trip to the pq and increment the count of passengers in uber
            pq.add(trips[i]);
            cur += trips[i][2];
            // if too many, return false
            if (cur > capacity)
                return false;
        }
        return true;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        // for(int[] trip : trips){
        //     pq.offer(trip);
        // }

        // int time = 0;
        // int current = 0;

        // List<int[]> list = new ArrayList<>();

        // while(pq.size() > 0){

        //     int[] curr = pq.poll();
        //     time = curr[0];

        //     int i = 0;
        //     while(i < list.size()){
        //         int[] arr = list.get(i);
        //         if(arr[1] <= time){
        //             current -= arr[2];
        //             list.remove(arr);
        //         }else{
        //             i++;
        //         }
        //     }

        //     current += curr[2];
        //     list.add(curr);
        //     if(current > capacity) return false;

        // }

        // return true;
    }
}