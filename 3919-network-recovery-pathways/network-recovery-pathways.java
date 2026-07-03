public class Solution {

    // Topological Sort (Kahn's Algorithm)
    public ArrayList<Integer> topologicalSort(int n, List<List<int[]>> graph) {
        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for (int[] edge : graph.get(curr)) {
                int v = edge[0];
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        return result;
    }

    // Check if a path exists from 0 to n-1 with min edge weight >= m and total cost <= k
    public boolean isPathPossible(ArrayList<Integer> tSort, List<List<int[]>> graph, int minEdgeWeight, int n, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int u : tSort) {
            if (dist[u] == Long.MAX_VALUE) continue;
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int wt = edge[1];

                if (wt >= minEdgeWeight && dist[u] + wt < dist[v] && dist[u] + wt <= k) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        return dist[n - 1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int left = Integer.MAX_VALUE;
        int right = 0;

        // Build graph only with online nodes and track edge weights for binary search
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (!online[u] || !online[v]) continue;

            graph.get(u).add(new int[]{v, wt});
            left = Math.min(left, wt);
            right = Math.max(right, wt);
        }

        ArrayList<Integer> tSort = topologicalSort(n, graph);
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPathPossible(tSort, graph, mid, n, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
