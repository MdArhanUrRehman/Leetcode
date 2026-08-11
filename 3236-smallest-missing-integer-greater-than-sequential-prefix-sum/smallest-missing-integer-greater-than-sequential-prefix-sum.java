class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int sum = nums[0];

        for(int i=0; i<n; i++){
           set.add(nums[i]);
        }

        for(int i=1; i<n; i++){
            if(nums[i-1]+1 == nums[i]){
                sum += nums[i];
            }else{
                break;
            }
        }

        while(true){
            if(set.contains(sum)){
                sum++;
            }else{
                break;
            }
        }

        return sum;
    }
}