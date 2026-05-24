class Solution {

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;
        int[] dp = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d, dp));
        }

        return ans;
    }

    private int dfs(int i, int[] arr, int d, int[] dp) {

        // already calculated
        if (dp[i] != 0) {
            return dp[i];
        }

        int max = 1; // count current index

        // check right side
        for (int x = 1; x <= d; x++) {

            int j = i + x;

            // out of bounds
            if (j >= arr.length) {
                break;
            }

            // blocked by greater/equal value
            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(j, arr, d, dp));
        }

        // check left side
        for (int x = 1; x <= d; x++) {

            int j = i - x;

            // out of bounds
            if (j < 0) {
                break;
            }

            // blocked by greater/equal value
            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(j, arr, d, dp));
        }

        dp[i] = max;

        return max;
    }
}