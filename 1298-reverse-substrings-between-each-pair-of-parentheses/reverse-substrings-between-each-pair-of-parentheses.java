class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();

        Stack<Character> st = new Stack();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                Queue<Character> q = new LinkedList<>();

                while (!st.isEmpty() && st.peek() != '(') {
                    q.add(st.pop());
                }

                st.pop();

                while (!q.isEmpty()) {

                    st.push(q.remove());

                }
            } else {
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}