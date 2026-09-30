class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int A = 0;
        int B = 0;
        int ans[] = new int[n];
        Stack<Character> st = new Stack();

        for(int i=0; i<n; i++){
            char ch = seq.charAt(i);

            if(ch == '('){
                if(A > B){
                   st.add('B');
                   B++;
                   ans[i] = 1;
                }else if(B > A){
                    st.add('A');
                    A++;
                    ans[i] = 0;
                }else{
                    st.add('A');
                    A++;
                    ans[i] = 0;
                }
            }else{
                char lastChar = st.pop();

                if(lastChar == 'A'){
                    ans[i] = 0;
                    A--;
                }else{
                    ans[i] = 1;
                    B--;
                }
            }
        }

        return ans;
    }
}