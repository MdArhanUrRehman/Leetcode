class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else {
                if(i+1 < n && s.charAt(i+1)== ')'){
                    i++;
                }else{
                    cnt++;
                }

                if(!st.isEmpty()){
                    st.pop();
                }else{
                    cnt++;
                }

            }
        }

        cnt += st.size() * 2;

        return cnt;

    }
}