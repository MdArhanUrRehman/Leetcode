
import java.util.*;

class Solution {

    static class HashPair {
        long h1, h2;

        HashPair(long h1, long h2) {
            this.h1 = h1;
            this.h2 = h2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof HashPair)) return false;

            HashPair other = (HashPair) obj;
            return h1 == other.h1 && h2 == other.h2;
        }

        @Override
        public int hashCode() {
            return 31 * Long.hashCode(h1) + Long.hashCode(h2);
        }
    }

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long base1 = 31;
        long base2 = 37;

        long mod1 = 1_000_000_007L;
        long mod2 = 1_000_000_009L;

        long[] prefix1 = new long[n + 1];
        long[] prefix2 = new long[n + 1];

        long[] power1 = new long[n + 1];
        long[] power2 = new long[n + 1];

        power1[0] = 1;
        power2[0] = 1;

        // Build both prefix hashes and power arrays
        for (int i = 0; i < n; i++) {

            long value1 = ((long) nums[i] + 1) % mod1;
            long value2 = ((long) nums[i] + 1) % mod2;

            if (value1 < 0) value1 += mod1;
            if (value2 < 0) value2 += mod2;

            prefix1[i + 1] =
                (prefix1[i] * base1 + value1) % mod1;

            prefix2[i + 1] =
                (prefix2[i] * base2 + value2) % mod2;

            power1[i + 1] =
                (power1[i] * base1) % mod1;

            power2[i + 1] =
                (power2[i] * base2) % mod2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isUnique(mid, n, prefix1, prefix2,
                         power1, power2, mod1, mod2)) {

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
        long[] prefix1,
        long[] prefix2,
        long[] power1,
        long[] power2,
        long mod1,
        long mod2
    ) {

        HashMap<HashPair, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            int j = i + len;

            long h1 = (
                prefix1[j] -
                (prefix1[i] * power1[len]) % mod1 +
                mod1
            ) % mod1;

            long h2 = (
                prefix2[j] -
                (prefix2[i] * power2[len]) % mod2 +
                mod2
            ) % mod2;

            HashPair key = new HashPair(h1, h2);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int freq : map.values()) {
            if (freq == 1) {
                return true;
            }
        }

        return false;
    }
}
