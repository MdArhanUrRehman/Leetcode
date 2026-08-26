class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int j = 0;
        int n = s.length();
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        StringBuilder prev = new StringBuilder();

        for (int i = 0; i < n; i++) {

            sb.append(s.charAt(i));

            if (s.charAt(i) == '1') {
                cnt++;
            }

            while (j <= i && cnt > k) {

                if (s.charAt(j) == '1') {
                    cnt--;
                }

                sb.deleteCharAt(0);
                j++;
            }

            while (j <= i && s.charAt(j) == '0') {
                sb.deleteCharAt(0);
                j++;
            }

            if (cnt == k) {

                if (prev.length() == 0 ||
                        sb.length() < prev.length() ||
                        (sb.length() == prev.length()
                                && sb.toString().compareTo(prev.toString()) < 0)) {

                    prev = new StringBuilder(sb);
                }
            }
        }

        return prev.toString();
    }
}