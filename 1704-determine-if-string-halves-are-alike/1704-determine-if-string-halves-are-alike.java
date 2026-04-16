import java.util.*;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));
        
        int n = s.length();
        int mid = n / 2;
        int countA = 0, countB = 0;
        
        // Count vowels in first half
        for (int i = 0; i < mid; i++) {
            if (vowels.contains(s.charAt(i))) {
                countA++;
            }
        }
        
        // Count vowels in second half
        for (int i = mid; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                countB++;
            }
        }
        
        return countA == countB;
    }
}
