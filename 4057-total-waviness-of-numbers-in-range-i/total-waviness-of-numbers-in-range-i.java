class Solution {

    public int getWaviness(int num) {

        String s = String.valueOf(num);

        int count = 0;

        for (int i = 1; i < s.length() - 1; i++) {

            char left = s.charAt(i - 1);
            char mid = s.charAt(i);
            char right = s.charAt(i + 1);

            // Peak
            if (mid > left && mid > right) {
                count++;
            }

            // Valley
            else if (mid < left && mid < right) {
                count++;
            }
        }

        return count;
    }

    public int totalWaviness(int num1, int num2) {

        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            ans += getWaviness(num);
        }

        return ans;
    }
}