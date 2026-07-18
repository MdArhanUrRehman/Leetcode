class Solution {

    private int GCD(int a, int b){
        if(b == 0){
            return a;
        }

        return GCD(b, a % b);
    }

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        return GCD(min, max);
    }
}