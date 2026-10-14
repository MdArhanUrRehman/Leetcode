class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int candidate = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }else if(nums[i] == candidate){
                count++;
            }else{
                count--;
            }
        }

        count = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == candidate){
                count++;
            }
        }

        if(count > n/2){
            return candidate;
        }

        return -1;
    }
}