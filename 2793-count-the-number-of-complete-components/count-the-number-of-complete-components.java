class Solution {

    int e = 0;
    int m = 0;

    public void dfs(ArrayList<ArrayList<Integer>> list, int curr, boolean visited[]){
        visited[curr] = true;
        m++;

        for(int i=0; i<list.get(curr).size(); i++){
            e++;
            if(!visited[list.get(curr).get(i)]){
                dfs(list, list.get(curr).get(i), visited);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                e = 0;
                m = 0;

                dfs(list, i, visited);
                int currEdges = e/2;
                if(m*(m-1)/2 == currEdges){
                    count++;
                }
            }
        }

        return count;
    }
}