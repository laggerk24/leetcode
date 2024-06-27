class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int neighbor : adjList.get(i)) {
                neighbors.add(vals[neighbor]);
            }

            Collections.sort(neighbors, Collections.reverseOrder());
            int sum = vals[i];
            for (int j = 0; j < Math.min(k, neighbors.size()); j++) {
                int element = neighbors.get(j);
                sum += element;
                ans = Math.max(Math.max(ans,element), sum);
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}