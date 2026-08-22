class Solution {
    public boolean checkDivisibility(int n) {
        int org = n;
        int sum = 0;
        int prod = 1;

        while(n != 0){
            int lastDigi = n % 10;
            sum += lastDigi;
            prod *= lastDigi;
           
            n/=10;
        }

        return (org % (sum + prod)) == 0;
    }
}