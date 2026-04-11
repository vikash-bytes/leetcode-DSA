class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if ((target + total) % 2 != 0 || target > total || target < -total) return 0;

        int P = (target + total) / 2;
        int[] dp = new int[P + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = P; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[P];
    }
}
