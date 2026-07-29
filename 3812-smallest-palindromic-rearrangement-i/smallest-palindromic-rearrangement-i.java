class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];

        int n = s.length();

        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int half = n / 2;
        char isAlone = ' ';

        for(int i=0; i<26; i++){
            char ch = (char)('a' + i);
            int rep = freq[i] / 2;

            if((freq[i] & 1) == 1){
                isAlone = ch;
            }

            while(rep-- > 0){
                sb.append(ch);
            }
        }


        StringBuilder ans = new StringBuilder();
        ans.append(sb);
        if(isAlone != ' '){
            sb.append(isAlone);
        }

        ans.append(new StringBuilder(sb).reverse());

        return ans.toString();


    }
}