class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int si = 0;
        int min = Integer.MAX_VALUE;

        while(si < n){
            min = Math.min(nums[si], min);
            si++;
        }

        return min;
    }
}