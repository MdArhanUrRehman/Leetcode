class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int si = 0;
        int ei = n-1;

        while(si < ei){
            int mid = si + (ei - si) / 2;

            if(nums[mid] > nums[ei]){
                si = mid + 1;
            }else{
                ei = mid;
            }
        }

        return nums[si];
    }
}