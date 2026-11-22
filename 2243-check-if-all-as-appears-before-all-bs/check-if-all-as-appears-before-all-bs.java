class Solution {
    public boolean checkString(String s) {
        boolean isB = false;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == 'a' && isB){
                return false;
            }

            if(!isB && ch == 'b'){
                isB = true;
            }
        }

        return true;
    }
}