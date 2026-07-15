class Solution {

    public int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;
        int odd = 1;
        int even = 2;

        for (int i = 1; i <= n; i++) {
            oddSum += odd;
            evenSum += even;
            odd += 2;
            even += 2;
        }

        return n;
    }
}