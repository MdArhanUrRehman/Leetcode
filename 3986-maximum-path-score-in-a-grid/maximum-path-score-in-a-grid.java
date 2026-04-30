class Solution {

    int[][][] memo;

    private int solve(int i, int j, int cost, int k, int[][] grid) {


        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        int newCost = cost + (grid[i][j] == 0 ? 0 : 1);

        if (newCost > k) {
            return Integer.MIN_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (memo[i][j][newCost] != -1) {
            return memo[i][j][newCost];
        }

        int down = solve(i + 1, j, newCost, k, grid);
        int right = solve(i, j + 1, newCost, k, grid);

        int bestNext = Math.max(down, right);

        if (bestNext == Integer.MIN_VALUE) {
            return memo[i][j][newCost] = Integer.MIN_VALUE;
        }

        return memo[i][j][newCost] = grid[i][j] + bestNext;
    }

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        memo = new int[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        int result = solve(0, 0, 0, k, grid);

        return result < 0 ? -1 : result;
    }
}