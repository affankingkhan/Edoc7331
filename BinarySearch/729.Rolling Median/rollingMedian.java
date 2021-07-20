// https://binarysearch.com/problems/Rolling-Median
import java.util.*;

class RollingMedian {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public RollingMedian() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
    }

    public void add(int val) {
        int lSize = left.size();
        int rSize = right.size();

        if (lSize == 0 && rSize == 0) {
            right.offer(val);
        } else if (lSize == 0) {
            int minRight = right.peek();
            if (val > minRight) {
                minRight = right.poll();
                left.offer(minRight);
                right.offer(val);
            } else {
                left.offer(val);
            }
        } else {
            int lMax = left.peek();
            int rMin = right.peek();
            if (lSize == rSize) {
                if (val > rMin) {
                    right.offer(val);
                } else {
                    left.offer(val);
                }

            } else {
                if (lSize > rSize) {
                    if (val < lMax) {
                        lMax = left.poll();
                        right.offer(lMax);
                        left.offer(val);
                    } else {
                        right.offer(val);
                    }

                } else {
                    if (val > rMin) {
                        rMin = right.poll();
                        left.offer(rMin);
                        right.offer(val);
                    } else {
                        left.offer(val);
                    }
                }
            }
        }
    }

    public double median() {
        int lSize = left.size();
        int rSize = right.size();

        if (lSize == rSize) {
            int l = left.peek();
            int r = right.peek();
            return (double) (l + r) / 2d;

        }

        else if (lSize > rSize) {
            int l = left.peek();
            return (double) l;
        }

        else {
            int r = right.peek();
            return (double) r;
        }
    }
}