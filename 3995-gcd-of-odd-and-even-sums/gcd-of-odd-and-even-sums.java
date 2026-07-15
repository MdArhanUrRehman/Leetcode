class Solution {

    private int GCD(int a, int b){
        if(b == 0){
            return a;
        }

        return GCD(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        int even = 0;
        int odd = 0;

        for(int i=1; i<=(n*2); i+=2){
            even+=i;
            odd+=i+1;
        }

        return GCD(odd, even);
    }
}