import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        // Iterate over all subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                if (!seen.contains(nums[j])) {
                    countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
                    seen.add(nums[j]);
                }
            }
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result = Math.max(result, entry.getKey());
            }
        }

        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna