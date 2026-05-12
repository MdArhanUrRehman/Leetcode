class Solution {

    private boolean isPossible(int[][] tasks, int req){
        int n = tasks.length;
        int m = tasks[0].length;

        for(int i=0; i<n; i++){
            int ac = tasks[i][0];
            int min = tasks[i][1];

            if(req < min){
                return false;
            }
            req-=ac;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int m = tasks[0].length;
        
        // Keep your energy high enough for future tasks, need very high minimum energy
        Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );

        int energy = 0;
        for (int i = 0; i < n; i++) {
            int ene = tasks[i][1];
            energy += ene;
        }

        int se = 0;
        int ee = energy;

        while(se < ee){
            int mid = se + (ee - se) / 2;

            if(isPossible(tasks, mid)){
                ee = mid;
            }else{
                se = mid + 1;
            }
        }

        return se;
    }
}