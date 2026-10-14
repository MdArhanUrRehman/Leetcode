class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (candidate1 != null && nums[i] == candidate1) {
                count1++;
            } else if (candidate2 != null && nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (candidate1 != null && nums[i] == candidate1) {
                count1++;
            }
            if (candidate2 != null && nums[i] == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > (n / 3)) {
            ans.add(candidate1);
        }
        if (count2 > (n / 3)) {
            ans.add(candidate2);
            return ans;
        }

        return ans;
    }
}