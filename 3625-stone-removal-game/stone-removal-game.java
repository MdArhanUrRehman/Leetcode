class Solution {
    public boolean canAliceWin(int n) {

        boolean isAlice = true;
        int stones = 10;
        
        while(n >= stones){
            if(isAlice){
                n-=stones;
                stones--;
                isAlice = false;
            }else{
                n-=stones;
                stones--;
                isAlice = true;
            }
        }

        return !isAlice;
    }
}