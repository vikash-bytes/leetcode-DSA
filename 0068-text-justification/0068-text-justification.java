import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            
            // Greedily add words until exceeding maxWidth
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }
            
            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();
            
            // If last line OR only one word → left-justified
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                // Fill remaining spaces
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Fully justified line
                int totalSpaces = maxWidth - (lineLen - gaps);
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        // Distribute spaces evenly, extra spaces go to left slots
                        for (int s = 0; s < spacePerGap; s++) sb.append(" ");
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }
            
            result.add(sb.toString());
            i = j;
        }
        
        return result;
    }
}
