class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        int i=0;
        long cal = mass;

        for(; i<n; i++){
            if(cal >= asteroids[i]){
                cal+=asteroids[i];
            }else{
                break;
            }
        }

        return i == n;
    }
}