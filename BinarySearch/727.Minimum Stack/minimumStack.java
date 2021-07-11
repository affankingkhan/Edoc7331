// https://binarysearch.com/problems/Minimum-Stack
import java.util.*;

class MinimumStack {
    ArrayDeque<int[]> stack;
    public MinimumStack() {
        stack = new ArrayDeque<>();
    }

    public void append(int val) {
        if (stack.size() == 0) {
            stack.push(new int[] {val, val});

        } else {
            int[] prev = stack.peek();
            int newMin = Math.min(val, prev[1]);
            stack.push(new int[] {val, newMin});
        }
    }

    public int peek() {
        return stack.peek()[0];
    }

    public int min() {
        return stack.peek()[1];
    }

    public int pop() {
        return stack.pop()[0];
    }
}