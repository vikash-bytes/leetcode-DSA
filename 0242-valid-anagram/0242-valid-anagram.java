class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // for lowercase English letters

        // Count characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Subtract counts using t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false; // more of this char in t than in s
            }
        }

        return true;
    }
}
