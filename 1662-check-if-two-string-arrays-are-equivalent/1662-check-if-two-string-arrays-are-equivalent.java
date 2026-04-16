class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Concatenate all strings in word1
        StringBuilder sb1 = new StringBuilder();
        for (String w : word1) {
            sb1.append(w);
        }

        // Concatenate all strings in word2
        StringBuilder sb2 = new StringBuilder();
        for (String w : word2) {
            sb2.append(w);
        }

        // Compare the final strings
        return sb1.toString().equals(sb2.toString());
    }
}
