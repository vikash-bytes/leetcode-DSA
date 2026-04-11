class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501]; // since 1 <= arr[i] <= 500
        
        // Step 1: Count frequencies
        for (int num : arr) {
            freq[num]++;
        }
        
        // Step 2: Check lucky numbers from largest to smallest
        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        
        return -1; // no lucky number found
    }
}
