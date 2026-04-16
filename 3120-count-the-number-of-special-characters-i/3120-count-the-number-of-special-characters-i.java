import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        
        // Traverse the string
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(Character.toLowerCase(ch));
            }
        }
        
        // Count intersection
        int count = 0;
        for (char ch : lower) {
            if (upper.contains(ch)) {
                count++;
            }
        }
        
        return count;
    }
}
