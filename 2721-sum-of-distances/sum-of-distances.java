import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(List<Integer> lst : map.values()){
            int size = lst.size();

            long[] prefix = new long[size];
            prefix[0] = lst.get(0);

            for(int i=1; i<size; i++){
                prefix[i] = prefix[i-1] + lst.get(i);
            }

            for(int i=0; i<size; i++){
                int idx = lst.get(i);

                long left = (long)idx * i - (i > 0 ? prefix[i-1] : 0);
                long right = (prefix[size - 1] - prefix[i]) - (long) idx * (size - i - 1);
                res[idx] = left + right;
            }
        }

        return res;    }
}