class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        
        // Build prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        // Memoization table
        int[][] dp = new int[n][n];
        return helper(0, n - 1, prefix, dp);
    }
    
    private int helper(int l, int r, int[] prefix, int[][] dp) {
        if (l == r) return 0; // only one stone left
        if (dp[l][r] != 0) return dp[l][r];
        
        int best = 0;
        for (int i = l; i < r; i++) {
            int leftSum = prefix[i + 1] - prefix[l];
            int rightSum = prefix[r + 1] - prefix[i + 1];
            
            if (leftSum < rightSum) {
                best = Math.max(best, leftSum + helper(l, i, prefix, dp));
            } else if (leftSum > rightSum) {
                best = Math.max(best, rightSum + helper(i + 1, r, prefix, dp));
            } else {
                best = Math.max(best, leftSum + helper(l, i, prefix, dp));
                best = Math.max(best, rightSum + helper(i + 1, r, prefix, dp));
            }
        }
        
        dp[l][r] = best;
        return best;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna