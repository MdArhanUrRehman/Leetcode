class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String st = words[i];
            int m = st.length();
            int sum = 0;

            for(int j=0; j<m; j++){
                sum+=weights[(int)(st.charAt(j) - 'a')];
            }
            System.out.println(sum);
            sb.append((char)('z' - (sum % 26)));
        }

        return sb.toString();
    }
}