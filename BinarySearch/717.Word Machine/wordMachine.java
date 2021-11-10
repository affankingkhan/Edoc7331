// https://binarysearch.com/problems/Word-Machine
import java.util.*;

class Solution {
    final String POP = "POP";
    final String DUP = "DUP";
    final String PLUS = "+";
    final String MINUS = "-";

    public int solve(String[] ops) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String op : ops) {
            switch (op) {
                case POP:
                    if (!stack.isEmpty())
                        stack.pop();
                    else {
                        return -1;
                    }
                    break;

                case "DUP":
                    if (stack.isEmpty())
                        return -1;
                    else {
                        stack.push(stack.peek());
                    }
                    break;

                case PLUS:
                    if (stack.size() < 2)
                        return -1;
                    else {
                        int first = stack.pop();
                        int second = stack.pop();
                        stack.push(first + second);
                    }
                    break;

                case MINUS:
                    if (stack.size() < 2)
                        return -1;
                    else {
                        int first = stack.pop();
                        int second = stack.pop();
                        stack.push(first - second);
                    }
                    break;

                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        return stack.isEmpty() ? -1 : stack.peek();
    }
}