class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101]; // since 1 <= nums[i] <= 100
        int count = 0;
        
        for (int num : nums) {
            // Each time we see num, it forms 'freq[num]' new pairs
            count += freq[num];
            freq[num]++;
        }
        
        return count;
    }
}
