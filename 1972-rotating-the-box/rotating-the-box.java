class Solution {

    private void solve(char[] grid){
        int n = grid.length;
        int j = n-1;
        int i = n-1;
        boolean empty = false;

        while(i>=0){
            if(!empty && grid[i] == '.'){
                j = i;
                empty = true;
            }else if(grid[i] == '*'){
                j = i - 1;
                empty = false;
            }else if(grid[i] == '#'){
                char temp = grid[j];
                grid[j] = grid[i];
                grid[i] = temp;
                j--;
            }

            i--;
        }
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char result[][] = new char[m][n];

        for(int i=0; i<n; i++){
            solve(boxGrid[i]);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[j][n-i-1] = boxGrid[i][j];
            }
        }

        return result;
        
    }
}