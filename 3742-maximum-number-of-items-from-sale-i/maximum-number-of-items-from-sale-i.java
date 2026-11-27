class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int dp[] = new int[budget+1];
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int factor = items[i][0];
            int value = items[i][1];

            int rewards = 0;
            min = Math.min(value, min);

            for(int j=0; j<n; j++){
                if(i != j && (items[j][0] % factor)== 0){
                   rewards++;
                }
            }

            int firstPurchase = 1 + rewards;

            for(int j=budget; j>=value; j--){
                dp[j] = Math.max(dp[j], dp[j-value] + firstPurchase);
            }
        }

        int ans = 0;

        for(int i=0; i<=budget; i++){
            int extraCopies = (budget - i) / min;
            ans = Math.max(extraCopies + dp[i], ans);
        }

        return ans;
    }
}