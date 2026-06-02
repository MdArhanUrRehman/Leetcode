class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            int count = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {
                int val = waterStartTime[j] < count ? count + waterDuration[j] : waterStartTime[j] + waterDuration[j];

                min = Math.min(val, min);
            }
        }
        
        for (int i = 0; i < waterStartTime.length; i++) {
            int count = waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < landStartTime.length; j++) {
                int val = landStartTime[j] < count ? count + landDuration[j] : landStartTime[j] + landDuration[j];

                min = Math.min(val, min);
            }
        }

        

        return min;
    }
}