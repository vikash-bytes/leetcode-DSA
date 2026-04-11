class Solution {
    public int numberOfWays(int n) {
        if (n <= 2) return n;  // base cases

        int a = 1; // T(1)
        int b = 2; // T(2)

        for (int i = 3; i <= n; i++) {
            int c = a + b; // recurrence relation
            a = b;
            b = c;
        }

        return b; // T(n)
    }
}
