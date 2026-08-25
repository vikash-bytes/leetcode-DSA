import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Put all numbers into a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Start checking multiples of k from k itself
        int multiple = k;
        while (true) {
            if (!set.contains(multiple)) {
                return multiple; // Found the smallest missing multiple
            }
            multiple += k;
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna