class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int j = 0;

        int max = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
            while (map.containsKey(val) && map.get(val) > k) {
                int reduce_freq = nums[j];
                map.put(reduce_freq, map.get(reduce_freq) - 1);
                j++;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}