import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        // Step 1: Build map of reserved seats per row
        for (int[] seat : reservedSeats) {
            int row = seat[0], col = seat[1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }
        
        int result = 0;
        
        // Step 2: Process rows with reservations
        for (int row : map.keySet()) {
            Set<Integer> reserved = map.get(row);
            
            boolean blockA = !(reserved.contains(2) || reserved.contains(3) || reserved.contains(4) || reserved.contains(5));
            boolean blockB = !(reserved.contains(4) || reserved.contains(5) || reserved.contains(6) || reserved.contains(7));
            boolean blockC = !(reserved.contains(6) || reserved.contains(7) || reserved.contains(8) || reserved.contains(9));
            
            if (blockA && blockC) {
                result += 2;
            } else if (blockA || blockB || blockC) {
                result += 1;
            }
        }
        
        // Step 3: Rows without reservations can fit 2 families
        result += (n - map.size()) * 2;
        
        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna