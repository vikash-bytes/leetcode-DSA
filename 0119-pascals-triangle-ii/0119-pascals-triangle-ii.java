import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // First element is always 1

        // Build row using the formula: C(n, k) = C(n, k-1) * (n-k+1)/k
        for (int k = 1; k <= rowIndex; k++) {
            long prev = row.get(k - 1); // Use long to avoid overflow during calculation
            long next = prev * (rowIndex - k + 1) / k;
            row.add((int) next);
        }

        return row;
    }
}
