import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // sort ascending
        int n = citations.length;
        int h = 0;
        
        // Traverse from the end (highest citations)
        for (int i = 0; i < n; i++) {
            int papers = n - i; // number of papers with citations >= citations[i]
            h = Math.max(h, Math.min(citations[i], papers));
        }
        
        return h;
    }
}
