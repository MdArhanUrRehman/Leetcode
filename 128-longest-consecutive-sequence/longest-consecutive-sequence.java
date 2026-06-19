class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int len = 1;
        int max = 0;

        for (int num : set) {
            int val = num;
            len = 1;
            if (!set.contains(num - 1)) {

                while (set.contains(val + 1)) {
                    val++;
                    len++;
                }

                max = Math.max(len, max);
            }
        }
        return max;
    }

}