import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Step 1: Sort balloons by their end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one arrow needed
        int end = points[0][1]; // Position of the first arrow

        // Step 2: Greedily shoot arrows
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // Current balloon starts after the last arrow's reach
                arrows++;
                end = points[i][1]; // Shoot a new arrow at this balloon's end
            }
            // If points[i][0] <= end, the current balloon is already burst
        }

        return arrows;
    }
}
