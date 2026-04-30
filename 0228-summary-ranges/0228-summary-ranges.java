import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = nums[0]; // beginning of current range

        for (int i = 1; i <= nums.length; i++) {
            // End of array OR break in consecutive sequence
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // single number
                } else {
                    result.add(start + "->" + nums[i - 1]); // range
                }
                // Reset start for next range
                if (i < nums.length) start = nums[i];
            }
        }

        return result;
    }
}
