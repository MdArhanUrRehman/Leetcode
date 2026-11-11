
class Solution {

    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        long t1 = (long) cost1 * need1 +
                  (long) cost2 * need2;

        // Buy Type 3 for need1, then Type 2 for remaining need2
        long req1 = (long) costBoth * need1;

        if (need2 > need1) {
            req1 += (long) cost2 * (need2 - need1);
        }

        // Buy Type 3 for need2, then Type 1 for remaining need1
        long req2 = (long) costBoth * need2;

        if (need1 > need2) {
            req2 += (long) cost1 * (need1 - need2);
        }

        // Buy Type 3 for both requirements, even if some units are extra
        long req3 = (long) costBoth * Math.max(need1, need2);

        return Math.min(t1, Math.min(req1, Math.min(req2, req3)));
    }
}
