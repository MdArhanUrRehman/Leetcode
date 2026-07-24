class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int XOR_VAL = 2048;
        int n = nums.length;

        boolean range[] = new boolean[XOR_VAL];
        boolean ans[] = new boolean[XOR_VAL];
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                range[nums[i] ^ nums[j]] = true;
            }
        }

        for(int i=0; i<n; i++){
            int val = nums[i];
            for(int j=0; j<range.length; j++){
                if(range[j]){
                    ans[j ^ val] = true;
                }
            }
        }

        for(int i=0; i<ans.length; i++){
            if(ans[i]){
                count++;
            }
        }

        return count;

    }
}