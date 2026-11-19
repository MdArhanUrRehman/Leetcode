class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i] - nums[i]);
        }

        int max = nums[n - 1] - nums[0];

        return Math.min(
                nums[n - 1] - nums[2],
                Math.min(
                        nums[n - 2] - nums[1],
                        nums[n - 3] - nums[0]));

    }
}