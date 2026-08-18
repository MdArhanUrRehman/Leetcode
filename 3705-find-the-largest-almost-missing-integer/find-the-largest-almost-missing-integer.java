class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Frequency in the whole array
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // k == 1
        // Every subarray contains exactly one element.
        if (k == 1) {
            int maxVal = -1;

            for (int val : map.keySet()) {
                if (map.get(val) == 1) {
                    maxVal = Math.max(maxVal, val);
                }
            }

            return maxVal;
        }

        // k == n
        // There is only one subarray: the entire array.
        if (k == n) {
            int maxVal = nums[0];

            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }

            return maxVal;
        }

        // 1 < k < n
        int maxVal = -1;

        // First element can appear in exactly one window
        if (map.get(nums[0]) == 1) {
            maxVal = Math.max(maxVal, nums[0]);
        }

        // Last element can appear in exactly one window
        if (map.get(nums[n - 1]) == 1) {
            maxVal = Math.max(maxVal, nums[n - 1]);
        }

        return maxVal;
    }
}