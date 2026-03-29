class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; // slow pointer
        for (int num : nums) {
            // Always write first two elements
            // After that, only write if current num != nums[i-2]
            if (i < 2 || num != nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}
