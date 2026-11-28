
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        // Find maximum factor and minimum price
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count frequency of every factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Calculate gain for every factor
        int[] gain = new int[maxFactor + 1];

        for (int factor = 1; factor <= maxFactor; factor++) {

            int count = 0;

            // Count all factors divisible by current factor
            for (int multiple = factor;
                 multiple <= maxFactor;
                 multiple += factor) {

                count += freq[multiple];
            }

            // Exclude the current item itself
            gain[factor] = count - 1;
        }

        // Sort items by price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        long remaining = budget;
        long ans = 0;

        // Buy useful boosted copies first
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // One boosted purchase must cost less than
            // two normal purchases of the cheapest item
            if (price >= 2L * minPrice) {
                break;
            }

            // Maximum boosted copies we can purchase
            long copies = Math.min(
                (long) gain[factor],
                remaining / price
            );

            ans += copies * 2;
            remaining -= copies * price;
        }

        // Spend remaining budget on cheapest normal copies
        ans += remaining / minPrice;

        return (int) ans;
    }
}
