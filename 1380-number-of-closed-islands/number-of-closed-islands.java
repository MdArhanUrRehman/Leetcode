class Solution {

    private void dfs(int r, int c, int grid[][], int n, int m){
        if(r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != 0){
            return;
        }

        grid[r][c] = 1;

        dfs(r, c-1, grid, n, m);
        dfs(r+1, c, grid, n, m);
        dfs(r, c+1, grid, n, m);
        dfs(r-1, c, grid, n, m);
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            dfs(i, 0, grid, n, m);
            dfs(i, m-1, grid, n, m);
        }

        for(int i=0; i<m; i++){
            dfs(0, i, grid, n, m);
            dfs(n-1, i, grid, n, m);
        }

        int cnt = 0;
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(grid[i][j] == 0){
                    cnt++;
                    dfs(i, j, grid, n, m);
                }
            }
        }

        return cnt;
    }
}