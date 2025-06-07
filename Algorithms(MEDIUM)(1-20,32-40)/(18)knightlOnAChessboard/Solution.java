import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'knightlOnAChessboard' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts INTEGER n as parameter.
     */

public static List<List<Integer>> knightlOnAChessboard(int n) {
    List<List<Integer>> result = new ArrayList<>();

    for (int a = 1; a < n; a++) {
        List<Integer> row = new ArrayList<>();
        for (int b = 1; b < n; b++) {
            row.add(bfs(n, a, b));
        }
        result.add(row);
    }

    return result;
}

private static int bfs(int n, int a, int b) {
    int[][] directions = {
        { a,  b}, { a, -b}, {-a,  b}, {-a, -b},
        { b,  a}, { b, -a}, {-b,  a}, {-b, -a}
    };

    boolean[][] visited = new boolean[n][n];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int x = curr[0], y = curr[1], steps = curr[2];

        if (x == n - 1 && y == n - 1) {
            return steps;
        }

        for (int[] d : directions) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, steps + 1});
            }
        }
    }

    return -1; // not reachable
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> result = Result.knightlOnAChessboard(n);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                bufferedWriter.write(String.valueOf(result.get(i).get(j)));

                if (j != result.get(i).size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
