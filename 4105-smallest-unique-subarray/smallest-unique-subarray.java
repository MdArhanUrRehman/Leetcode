
class Solution {

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long base = 911382323L;
        long mod = 1_000_000_007L;

        // Precompute prefix hashes
        long[] prefix = new long[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;

        for (int i = 0; i < n; i++) {

            prefix[i + 1] =
                (prefix[i] * base + nums[i] + 1L) % mod;

            power[i + 1] = (power[i] * base) % mod;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isUnique(mid, n, prefix, power, base, mod)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isUnique(
        int len,
        int n,
        long[] prefix,
        long[] power,
        long base,
        long mod
    ) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            int j = i + len;

            long hash = (
                prefix[j] - (prefix[i] * power[len]) % mod + mod
            ) % mod;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int freq : map.values()) {

            if (freq == 1) {
                return true;
            }
        }

        return false;
    }
}
