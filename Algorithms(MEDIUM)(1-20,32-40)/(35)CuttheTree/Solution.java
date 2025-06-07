import java.util.*;

public class Solution {

    static int minDifference = Integer.MAX_VALUE;
    static int totalSum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
            totalSum += data[i];
        }

        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            tree[u].add(v);
            tree[v].add(u);
        }

        boolean[] visited = new boolean[n];
        dfs(0, tree, data, visited);

        System.out.println(minDifference);
        in.close();
    }

    static int dfs(int node, List<Integer>[] tree, int[] data, boolean[] visited) {
        visited[node] = true;
        int currentSum = data[node];

        for (int child : tree[node]) {
            if (!visited[child]) {
                int childSum = dfs(child, tree, data, visited);
                currentSum += childSum;
                int diff = Math.abs(totalSum - 2 * childSum);
                if (diff < minDifference) {
                    minDifference = diff;
                }
            }
        }

        return currentSum;
    }
}
