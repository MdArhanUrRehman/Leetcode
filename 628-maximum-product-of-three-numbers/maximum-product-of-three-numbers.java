class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int min1 = 0;
        int min2 = 0;
        int neg = 0;
        int sum = 0;

        return Math.max(nums[0] * nums[1] * nums[n-1],
         nums[n-1] * nums[n-2] * nums[n-3]);
    }
}