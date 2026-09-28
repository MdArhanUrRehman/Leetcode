class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int depth = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                depth++;
                max = Math.max(depth, max);
            }else if(ch == ')'){
                depth--;
                max = Math.max(depth, max);
            }
        }

        return max;
    }
}