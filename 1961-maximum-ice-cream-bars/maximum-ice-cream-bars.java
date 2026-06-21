class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int max = 0;

        for(int val : costs){
            max = Math.max(max, val);
        }

        int ele[] = new int[max+1];

        for(int val : costs){
            ele[val]++;
        }

        int ans = 0;

        for(int i=1; i<=max; i++){
            int curr = ele[i];
            while(curr != 0 && coins >= i){
                ans++;
                curr--;
                coins-=i;
            }

            if(coins == 0) break;
        }

        return ans;
    }
}