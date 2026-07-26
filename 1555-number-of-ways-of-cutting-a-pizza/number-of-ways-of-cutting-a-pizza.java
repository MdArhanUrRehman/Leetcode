class Solution {

    final int MOD = 1_000_000_007;

    private long solve(int r, int c, int k, int n, int m, int suffix[][], long dp[][][]){
        if(k == 1){
            if(suffix[r][c] > 0){
                return 1;
            }

            return 0;
        }

        if(dp[r][c][k] != -1){
            return dp[r][c][k];
        }

        long ans = 0;

        // Horizontal Cut
        for(int nr = r+1; nr < n; nr++){
            if(suffix[nr][c] == suffix[r][c]){
                continue;
            }
            ans = ans + solve(nr, c, k-1, n, m, suffix, dp) % MOD;
        }

        // Vertical Cut
        for(int nc = c+1; nc < m; nc++){
            if(suffix[r][nc] == suffix[r][c]){
                continue;
            }
            ans = ans + solve(r, nc, k-1, n, m, suffix, dp) % MOD;
        }

        return dp[r][c][k] = ans % MOD;
    }

    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();

        int corn_pizza[][] = new int[n][m];
        long dp[][][] = new long[n+1][m+1][k+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
                if(pizza[i].charAt(j) == 'A'){
                    corn_pizza[i][j] = 1;
                }else{
                    corn_pizza[i][j] = 0;
                }
            }
        }

        int suffix_corn[][] = new int[n+1][m+1];

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                suffix_corn[i][j] = corn_pizza[i][j] + suffix_corn[i+1][j] + suffix_corn[i][j+1] - suffix_corn[i+1][j+1];
            }
        }

        return (int)solve(0, 0, k, corn_pizza.length, corn_pizza[0].length, suffix_corn, dp) % MOD;
    }
}