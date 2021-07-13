// https://binarysearch.com/problems/Revolving-Door
import java.util.*;

class Solution {
    public int[][] solve(int[][] requests) {
        int m = requests.length;
        if (m < 2)
            return requests;

        Arrays.sort(requests, (a, b) -> a[0] - b[0]);

        // is door currently open (in) or closed (out);
        boolean isOpen = true;
        // first index of the same start time
        int idx = 0;
        // what is the current total Time elapsed
        int currentTime = requests[0][0];

        // what start time are we currently looking at
        int timeInterval = requests[0][0];

        // number of requests with startTime == timeInterval and that are trying to go in
        int inCount = 0;

        // number of requests with startTime == timeInterval and that are trying to go in
        int outCount = 0;

        for (int i = 0; i < m; i++) {
            // fetch the current request
            int[] req = requests[i];

            // if we are considering the same start time as the previous iteration
            if (req[0] == timeInterval) {
                // set the startTime to the currentTime and increment the currentTime
                req[0] = currentTime;
                currentTime++;
                // increment the appropriate in or out counter
                if (req[1] == 0) {
                    outCount++;
                } else {
                    inCount++;
                }

            }
            // if we are considering a different start time than the previous iteration
            else {
                // we need to popualte the all the previous starttimes with the correct open or
                // close if isOpen, we let the ones going in first, followed by the ones going out
                // else vice versa
                if (isOpen) {
                    while (inCount > 0) {
                        requests[idx++][1] = 1;
                        inCount--;
                        isOpen = true;
                    }
                    while (outCount > 0) {
                        requests[idx++][1] = 0;
                        outCount--;
                        isOpen = false;
                    }

                } else {
                    while (outCount > 0) {
                        requests[idx++][1] = 0;
                        outCount--;
                        isOpen = false;
                    }
                    while (inCount > 0) {
                        requests[idx++][1] = 1;
                        inCount--;
                        isOpen = true;
                    }
                }

                // deal with the current index
                // set timeInterval to the current startTime
                timeInterval = req[0];
                // refresh the 2 counters
                inCount = 0;
                outCount = 0;

                // if the currentTime is greater than or equal to the current requests startTime,
                // this one has just arrived or has been waiting
                // so we change the start time to the currentTime
                if (currentTime >= req[0]) {
                    req[0] = currentTime;

                }
                // else the door has not seen someone so we skip currentTime to the current requests
                // startTime and set the door to open
                else {
                    currentTime = req[0];
                    isOpen = true;
                }

                // increment the appropriate in or out counter
                if (req[1] == 0) {
                    outCount++;
                } else {
                    inCount++;
                }

                // increment the currentTime for the next iteration
                currentTime++;
            }
        }

        // there will be atleast one time not populate corretly until the end so we need to populate
        // the in out for the remaining
        if (isOpen) {
            while (inCount > 0) {
                requests[idx++][1] = 1;
                inCount--;
                isOpen = true;
            }
            while (outCount > 0) {
                requests[idx++][1] = 0;
                outCount--;
                isOpen = false;
            }

        } else {
            while (outCount > 0) {
                requests[idx++][1] = 0;
                outCount--;
                isOpen = false;
            }
            while (inCount > 0) {
                requests[idx++][1] = 1;
                inCount--;
                isOpen = true;
            }
        }

        return requests;
    }
}