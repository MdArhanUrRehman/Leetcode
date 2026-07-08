class Solution {

    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        int n = heights.length;
        int m = heights[0].length;

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            // First, check bounds
            if (ni < 0 || nj < 0 || ni >= n || nj >= m)
                continue;

            // Then check visited and if water can flow
            if (visited[ni][nj] || heights[ni][nj] < heights[i][j])
                continue;

            dfs(heights, ni, nj, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        //pacific
        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, pacific); // left edge
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, 0, j, pacific); // top edge
        }

        //atlantic
        for (int i = 0; i < n; i++) {
            dfs(heights, i, m - 1, atlantic);
        }

        for (int j = 0; j < m; j++) {
            dfs(heights, n - 1, j, atlantic);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return ans;
    }
}
