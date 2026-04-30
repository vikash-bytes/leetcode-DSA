class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26]; // for lowercase letters

        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check ransomNote against magazine counts
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false; // not enough characters
            }
        }

        return true;
    }
}
