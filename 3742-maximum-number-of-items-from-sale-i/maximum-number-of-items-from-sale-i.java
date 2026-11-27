class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        // Step 1: Calculate first-purchase reward for every item
        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            minPrice = Math.min(minPrice, price);

            int freeCopies = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    freeCopies++;
                }
            }

            // First purchased copy + free copies
            int reward = 1 + freeCopies;

            // Step 2: 0/1 Knapsack (backward iteration)
            for (int j = budget; j >= price; j--) {

                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + reward
                );
            }
        }

        // Step 3: Use remaining budget to buy cheapest items
        int ans = 0;

        for (int i = 0; i <= budget; i++) {

            int extraCopies = (budget - i) / minPrice;

            ans = Math.max(ans, dp[i] + extraCopies);
        }

        return ans;
    }
}