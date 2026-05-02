class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isRotated(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isRotated(int n){
        boolean isTrue = false;

        while (n > 0) {
            int lstDigi = n % 10;

            if (lstDigi == 3 || lstDigi == 4 || lstDigi == 7) {
                return false;
            }

            if (lstDigi == 2 || lstDigi == 5 || lstDigi == 6 || lstDigi == 9) {
                isTrue = true;
            }

            n /= 10;
        }

        return isTrue;

    }
}