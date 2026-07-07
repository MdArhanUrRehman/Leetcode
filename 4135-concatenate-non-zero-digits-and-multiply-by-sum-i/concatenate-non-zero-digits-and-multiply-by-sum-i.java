class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long x = 0;

        while (n != 0) {
            long lastDigi = n % 10;

            if (lastDigi != 0) {
                x = (x * 10) + lastDigi;
                sum += lastDigi;
            }
            n /= 10;
        }

        long y = 0;

        while (x != 0) {
            long lastDigi = x % 10;

            y = (y * 10) + lastDigi;
            x /= 10;
        }

        return y * sum;
    }
}