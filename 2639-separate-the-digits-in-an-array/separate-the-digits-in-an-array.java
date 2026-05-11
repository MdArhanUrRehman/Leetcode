class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;

        for(int i=n-1; i>=0; i--){
            int val = nums[i];

            while(val > 0){
                int lastDigi = val % 10;
                res.add(lastDigi);
                val/=10;
            }
        }

        int ans[] = new int[res.size()];
        int idx = 0;

        for(int i=res.size()-1; i>=0; i--){
            ans[idx++] = res.get(i);
        }

        return ans;
    }
}