class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int itemCnt = 0;
        int price = 0;

        for(int i=n-1; i>=0; i--){
            if(itemCnt == 2){
                itemCnt = 0;
                continue;
            }
            price+= cost[i];
            itemCnt++;
        }

        return price;
    }
}