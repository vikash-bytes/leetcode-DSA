class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefix = new int[n];
        
        // Build prefix sums
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }
        
        // DP from the end
        int best = prefix[n - 1];  // base case
        for (int i = n - 2; i >= 1; i--) {
            best = Math.max(best, prefix[i] - best);
        }
        
        return best;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna