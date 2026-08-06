class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int org = n;
            int sum = 1;

            while(org != 0){
                int lastDigi = org % 10;
                sum*=lastDigi;
                org/=10;
            }

            if(sum % t == 0){
                return n;
            }

            n = n + 1;
        }
    }
}