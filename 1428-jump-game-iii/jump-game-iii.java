class Solution {

    class Pair {
        int idx;
        int val;

        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    private boolean dfs(int curr, ArrayList<ArrayList<Pair>> adj, boolean vis[]) {
        vis[curr] = true;

        for (int i = 0; i < adj.get(curr).size(); i++) {
            Pair neigh = adj.get(curr).get(i);

            if (neigh.val == 0) {
                return true;
            }

            if (!vis[neigh.idx]) {
                if (dfs(neigh.idx, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int nextJump = i + arr[i];
            int prevJump = i - arr[i];

            if (nextJump < n) {
                adj.get(i).add(new Pair(nextJump, arr[i]));
            }

            if (prevJump >= 0) {
                adj.get(i).add(new Pair(prevJump, arr[i]));
            }
        }

        boolean vis[] = new boolean[n];

        return dfs(start, adj, vis);
    }
}