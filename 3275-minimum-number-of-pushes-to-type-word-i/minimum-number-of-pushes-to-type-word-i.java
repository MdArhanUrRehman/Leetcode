class Solution {
    public int minimumPushes(String word) {
        int[] alpha = new int[26];

        for (char ch : word.toCharArray()) {
            alpha[ch - 'a']++;
        }
        Arrays.sort(alpha);

        int pushes = 1;
        int ans = 0;

        for (int i = 25; i >= 0; i--) {
            if (alpha[i] == 0)
                break;

            ans += alpha[i] * pushes;

            if ((25 - i + 1) % 8 == 0) {
                pushes++;
            }

        }
        return ans;
    }
}