class Solution {

    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String newString = s + s;

        int n = goal.length();
        int m = newString.length();

        for(int i=0; i<m; i++){
            int start = i;
            int j = 0;

            while(start < m && j < n && newString.charAt(start) == goal.charAt(j)){
                start++;
                j++;
            }

            if(j == n) return true;
        }

        return false;
    }
}