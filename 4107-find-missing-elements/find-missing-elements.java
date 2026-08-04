class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int val : nums){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        boolean aux[] = new boolean[max + 1];

        for(int i=0; i<n; i++){
            aux[nums[i]] = true;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=min; i<=max; i++){
            if(!aux[i]){
                ans.add(i);
            }
        }

        return ans;
    }
}