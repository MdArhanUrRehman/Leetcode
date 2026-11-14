class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        long min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = i; j < n && j < i + r; j++) {
                sum += nums.get(j);

                if (j - i + 1 >= l && sum > 0) {
                    min = Math.min(min, sum);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : (int)min;
    }
}