class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }

        int incCount = 1;
        int deCount = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                incCount++;
                deCount = 1;
            } else if (nums[i - 1] > nums[i]) {
                deCount++;
                incCount = 1;
            } else {
                incCount = 1;
                deCount = 1;
            }

            maxLen = Math.max(maxLen, Math.max(incCount, deCount));
        }

        return maxLen;

    }
}