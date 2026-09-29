class Solution {

    private boolean isPossible(int r, int c, int n, int m, char grid[][], int balance, Boolean dp[][][]) {

        balance += grid[r][c] == '(' ? 1 : -1;
        if (balance < 0)
            return false;

        if (balance > (n + m))
            return false;

        if (r == n - 1 && c == m - 1) {
            return balance == 0;
        }

        boolean result = false;

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        if (r + 1 < n) {
            result = isPossible(r + 1, c, n, m, grid, balance, dp);
        }

        if (!result && c + 1 < m) {
            result = isPossible(r, c + 1, n, m, grid, balance, dp);
        }

        dp[r][c][balance] = result;

        return result;
    }

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == ')')
            return false;

        return isPossible(0, 0, n, m, grid, 0, new Boolean[n][m][n + m]);
    }
}