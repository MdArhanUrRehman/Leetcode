class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int n = nums.size();

        int bits[] = new int[32];

        for(int i=0; i<n; i++){
           int num = nums.get(i);
           int idx = 0;

           while (num > 0) {
                if ((num & 1) == 1) {
                    bits[idx]++;
                }

                num >>= 1;
                idx++;
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 31; j >= 0; j--) {
                if (bits[j] > 0) {
                    num |= (1L << j);
                    bits[j]--;
                }
            }

            ans = (ans + num * num) % MOD;
        }

        return (int) ans;
    }
}