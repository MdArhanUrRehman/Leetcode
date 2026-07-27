class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int fir_max = 0;
        int sec_max = 0;

        for(int i=0; i<n; i++){
            if(nums[i] > fir_max){
                sec_max = fir_max;
                fir_max = nums[i];
            }else if(nums[i] > sec_max){
                sec_max = nums[i];
            }
        }

        return (fir_max - 1) * (sec_max - 1);
    }
}