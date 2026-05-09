class Solution {

    private void reverse(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    private ArrayList<Integer> getVal(int[][] grid, int k,
            int startRow, int endRow,
            int startCol, int endCol) {

        ArrayList<Integer> aux = new ArrayList<>();

        // top
        for (int i = startCol; i <= endCol; i++) {
            aux.add(grid[startRow][i]);
        }

        // right
        for (int j = startRow + 1; j <= endRow; j++) {
            aux.add(grid[j][endCol]);
        }

        // bottom
        for (int i = endCol - 1; i >= startCol; i--) {
            aux.add(grid[endRow][i]);
        }

        // left
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            aux.add(grid[i][startCol]);
        }

        int len = aux.size();

        k = k % len;

        reverse(aux, 0, k - 1);
        reverse(aux, k, len - 1);
        reverse(aux, 0, len - 1);

        return aux;
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = m - 1;

        int ans[][] = new int[n][m];

        while (startRow <= endRow && startCol <= endCol) {
            ArrayList<Integer> temp = getVal(grid, k, startRow, endRow, startCol, endCol);
            int idx = 0;
            //top
            for (int i = startCol; i <= endCol; i++) {
                ans[startRow][i] = temp.get(idx++);
            }
            //right
            for (int j = startRow + 1; j <= endRow; j++) {
                ans[j][endCol] = temp.get(idx++);
            }
            //down
            for (int o = endCol - 1; o >= startCol; o--) {
                ans[endRow][o] = temp.get(idx++);
            }
            //left
            for (int l = endRow - 1; l >= startRow + 1; l--) {
                ans[l][startCol] = temp.get(idx++);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return ans;
    }
}