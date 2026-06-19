class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int max = 0;
        int n = gain.length;

        for(int i=0; i<n; i++){
            altitude += gain[i];
            max = Math.max(max, altitude);
        }

        return max;
    }
}