import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // default -1

        Stack<Integer> stack = new Stack<>(); // store indices

        // Traverse twice to simulate circular array
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) { // only push indices from first pass
                stack.push(i);
            }
        }

        return result;
    }
}
