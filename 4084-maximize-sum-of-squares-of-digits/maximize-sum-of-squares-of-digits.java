class Solution {
    public String maxSumOfSquares(int num, int sum) {

        if (sum > 9 * num) {
            return "";
        }

        StringBuilder cal = new StringBuilder();

        while (num > 0) {
            if (sum >= 9) {
                cal.append('9');
                sum -= 9;
            } else {
                cal.append((char) ('0' + sum));
                sum = 0;
            }

            num--;
        }

        return cal.toString();
    }
}