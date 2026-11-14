class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        long min = Long.MAX_VALUE;

        if (l == 1 && r == 1) {
            for (int num : nums) {
                if (num > 0) {
                    min = Math.min(min, num);
                }
            }

            return min == Long.MAX_VALUE ? -1 : (int) min;
        }

        int i = 0;
        int j = 0;

        while (j < n) {
            long sum = 0;
            i = j;

            while (i >= 0 && j - i + 1 <= r) {
                sum += nums.get(i);

                if (j - i + 1 >= l && j - i + 1 <= r && sum > 0) {
                    min = Math.min(min, sum);
                }

                i--;
            }

            j++;
        }

        return min == Long.MAX_VALUE ? -1 : (int) min;
    }
}