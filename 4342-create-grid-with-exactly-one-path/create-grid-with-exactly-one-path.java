class Solution {

    private boolean solve(int r, int c, char ch[][]) {
        int m = ch.length;
        int n = ch[0].length;
        if (r >= m || c >= n || r < 0 || c < 0) {
            return false;
        }

        ch[r][c] = '.';

        if (r == m - 1 && c == n - 1) {
            return true;
        }

        if (solve(r, c + 1, ch))
            return true;
        if (solve(r + 1, c, ch))
            return true;

        return false;
    }

    public String[] createGrid(int m, int n) {
        char ch[][] = new char[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(ch[i], '#');
        }

        solve(0, 0, ch);

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                sb.append(ch[i][j]);
            }
            ans[i] = sb.toString();
        }

        return ans;
    }

}