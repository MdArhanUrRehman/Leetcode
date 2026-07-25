class Solution {
    public int maxProduct(int n) {
        String str = String.valueOf(n);
        int max = 0;
        int m = str.length();

        for (int i = 0; i < m; i++) {
            int frst = str.charAt(i) - '0';
            for (int j = i + 1; j < m; j++) {
                int sec = str.charAt(j) - '0';

                max = Math.max(frst * sec, max);
            }
        }

        return max;
    }
}