class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        boolean isTrue = true;
        int val = nums[0];
        int min = val;

        for(int i=1; i<n; i++){
           if(val != nums[i]){
             isTrue = false;
           }
           min = Math.min(min, nums[i]);
        }

        if(isTrue) return 0;
        int ans = 0;

        for(int i=0; i<n; i++){
            ans+= (nums[i] - min);
        }

        return ans;
    }
}