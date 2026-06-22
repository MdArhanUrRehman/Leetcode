class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] ch = new int[26];
        int idx[] = { 1, 0, 11, 14, 13 };

        for (int i = 0; i < text.length(); i++) {
            ch[text.charAt(i) - 'a']++;
        }

        return Math.min(
                Math.min(Math.min(ch['b' - 'a'], ch['a' - 'a']), Math.min(ch['o' - 'a'] / 2, ch['l' - 'a'] / 2)),
                ch['n' - 'a']);
    }
}