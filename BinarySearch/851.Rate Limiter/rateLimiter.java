// https://binarysearch.com/problems/Rate-Limiter
import java.util.*;

class RateLimiter {
    HashMap<Integer, Integer> map;
    int exp;
    public RateLimiter(int expire) {
        map = new HashMap<>();
        exp = expire;
    }

    public boolean limit(int uid, int timestamp) {
        int previous = map.getOrDefault(uid, -1);
        if (previous < 0) {
            map.put(uid, timestamp);
            return false;
        }

        int lower = timestamp - this.exp;
        boolean ans = previous > lower;
        if (!ans) {
            map.put(uid, timestamp);
        }
        return ans;
    }
}