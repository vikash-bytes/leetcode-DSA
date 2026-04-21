import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case: first row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Build each row starting from the second
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> newRow = new ArrayList<>();

            // First element of each row is always 1
            newRow.add(1);

            // Middle elements are sum of two numbers above
            for (int j = 1; j < row; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element of each row is always 1
            newRow.add(1);

            triangle.add(newRow);
        }

        return triangle;
    }
}
