class Solution {

    public void isDivisible(int i, int j, int k, boolean[][] visited, int grid[][], long sum[]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        sum[0] += grid[i][j];

        isDivisible(i + 1, j, k, visited, grid, sum);
        isDivisible(i - 1, j, k, visited, grid, sum);
        isDivisible(i, j - 1, k, visited, grid, sum);
        isDivisible(i, j + 1, k, visited, grid, sum);

    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    q.add(new int[] { i, j });
                }
            }
        }

        boolean visited[][] = new boolean[n][m];
        int count = 0;

        while (!q.isEmpty()) {
            int[] val = q.poll();
            long sum[] = new long[1];
            if (!visited[val[0]][val[1]]) {
                isDivisible(val[0], val[1], k, visited, grid, sum);
                if (sum[0] % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}