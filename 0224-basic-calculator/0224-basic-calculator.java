import java.util.*;

class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1; // current sign (+1 or -1)
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // build multi-digit number
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // Push current result and sign onto stack
                stack.push(result);
                stack.push(sign);
                // Reset for new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                // Pop sign and previous result
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
            // Ignore spaces
        }

        // Add any remaining number
        result += sign * num;
        return result;
    }
}
