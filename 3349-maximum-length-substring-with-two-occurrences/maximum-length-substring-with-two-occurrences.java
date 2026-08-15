class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();

        int []ch = new int[26];
        int j = 0;

        int max = 0;

        for(int i=0; i<n; i++){
            int idx = s.charAt(i) - 'a';

            ch[idx]++;

            while(ch[idx] > 2){
                int id = s.charAt(j) - 'a';
                ch[id]--;
                j++;
            }

            max = Math.max(max, i - j +1);
        }
        return max;
    }
}