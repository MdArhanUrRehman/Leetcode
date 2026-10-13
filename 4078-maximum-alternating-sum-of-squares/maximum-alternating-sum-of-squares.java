class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        int sq[] = new int[n];

        for(int i=0; i<n; i++){
            sq[i] = (nums[i] * nums[i]);
        }

        Arrays.sort(sq);
        long sum = 0;
        int i=0;

        for(; i<n/2; i++){
            sum = (sum + (sq[n-i-1] - sq[i]));
        }

        if((n & 1) == 1){
            sum+=sq[i];
        }

        return sum;
    }
}