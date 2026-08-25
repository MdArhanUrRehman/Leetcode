class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for(int i=0; i<n; i++){
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int i=1;
        for(; i<=100 && i <= max; i++){
            int mul = k * i;
            if(!set.contains(mul)){
                return mul;
            }
        }

        return k * i;
    }
}