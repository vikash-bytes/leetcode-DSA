class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Edge case: empty needle
        if (m == 0) return 0;

        // Loop through haystack
        for (int i = 0; i <= n - m; i++) {
            // Check substring of length m
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
