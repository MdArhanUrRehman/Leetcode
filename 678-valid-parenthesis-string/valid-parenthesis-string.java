class Solution {

    Boolean[][] dp;

    private boolean solve(int curr, int balance, String s) {

        // More closing brackets than opening brackets
        if (balance < 0) {
            return false;
        }

        // End of string
        if (curr == s.length()) {
            return balance == 0;
        }

        // Already calculated
        if (dp[curr][balance] != null) {
            return dp[curr][balance];
        }

        char ch = s.charAt(curr);

        boolean ans;

        if (ch == '(') {

            // '(' increases balance
            ans = solve(curr + 1, balance + 1, s);

        } else if (ch == ')') {

            // ')' decreases balance
            ans = solve(curr + 1, balance - 1, s);

        } else {

            // '*' can be:
            // 1. '('
            // 2. ')'
            // 3. empty

            ans =
                solve(curr + 1, balance + 1, s) ||
                solve(curr + 1, balance - 1, s) ||
                solve(curr + 1, balance, s);
        }

        return dp[curr][balance] = ans;
    }

    public boolean checkValidString(String s) {

        int n = s.length();

        dp = new Boolean[n][n + 1];

        return solve(0, 0, s);
    }
}