class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int max = nums[n-1];
        int cnt = 0;

        if(n > (max + 1)){
            return false;
        }

        if(n <= max){
            return false;
        }

        for(int i=1; i<=max; i++){
            if(i != nums[i-1]){
                return false;
            }
        }

        return nums[n-1] == max ? true : false;
    }
}