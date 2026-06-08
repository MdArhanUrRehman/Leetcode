class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        int eq = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] < pivot){
                lst1.add(nums[i]);
            }else if(nums[i] > pivot){
                lst2.add(nums[i]);
            }else{
                eq++;
            }
        }

        int ans[] = new int[n];
        int idx = 0;

        for(int i=0; i<lst1.size(); i++){
            ans[idx++] = lst1.get(i);
        }

        while(eq-- > 0){
            ans[idx++] = pivot;
        }

        for(int i=0; i<lst2.size(); i++){
            ans[idx++] = lst2.get(i);
        }

        return ans;
    }
}