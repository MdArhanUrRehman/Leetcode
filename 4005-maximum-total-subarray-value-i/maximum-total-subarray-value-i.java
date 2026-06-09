class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long min = Integer.MAX_VALUE;
        long max = 0;

        for(int i=0; i<n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        min *= k;
        max *= k;

        return max - min;
    }
}