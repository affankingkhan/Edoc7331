// https://binarysearch.com/problems/Hit-Counter
import java.util.*;

class HitCounter {
    ArrayDeque<Integer> dq;
    public HitCounter() {
        dq = new ArrayDeque<>();
    }

    public void add(int timestamp) {
        int lastAllowed = timestamp - 60;
        if (lastAllowed > 0) {
            removeFromQueue(lastAllowed);
        }
        dq.offer(timestamp);
    }

    public int count(int timestamp) {
        int lastAllowed = timestamp - 60;
        if (lastAllowed > 0) {
            removeFromQueue(lastAllowed);
        }
        return dq.size();
    }

    private void removeFromQueue(int lastAllowed) {
        while (!dq.isEmpty()) {
            int curr = dq.peek();
            if (curr < lastAllowed) {
                dq.poll();
            } else {
                break;
            }
        }
    }
}