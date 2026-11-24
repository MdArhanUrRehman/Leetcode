class Solution {

    private int GCD(int a, int b){
         if(b  == 0){
            return a;
         }

         return GCD(b, a % b);
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        for(int i=0; i<n; i++){
            int product = 1;
            int gcd = 0;
            int lcm = 1;

            for(int j=i; j<n; j++){
                product*=nums[j];

                gcd = GCD(gcd, nums[j]);

                lcm = (lcm / GCD((int)lcm, nums[j])) * nums[j];

                if((lcm * gcd) == product){
                   maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}