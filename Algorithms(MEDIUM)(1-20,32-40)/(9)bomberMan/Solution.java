import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
   public static List<String> bomberMan(int n, List<String> grid) {
    if (n == 1) return grid;

    int r = grid.size();
    int c = grid.get(0).length();
    char[][] initial = toGrid(grid);
    char[][] full = createFullGrid(r, c);

    char[][] firstDetonation = detonate(initial, r, c);
    char[][] secondDetonation = detonate(firstDetonation, r, c);

    if (n % 2 == 0) {
        return toList(full);
    } else if (n % 4 == 3) {
        return toList(firstDetonation);
    } else {
        return toList(secondDetonation);
    }
}

private static char[][] toGrid(List<String> grid) {
    int r = grid.size(), c = grid.get(0).length();
    char[][] g = new char[r][c];
    for (int i = 0; i < r; i++) {
        g[i] = grid.get(i).toCharArray();
    }
    return g;
}

private static List<String> toList(char[][] grid) {
    List<String> list = new ArrayList<>();
    for (char[] row : grid) {
        list.add(new String(row));
    }
    return list;
}

private static char[][] createFullGrid(int r, int c) {
    char[][] full = new char[r][c];
    for (int i = 0; i < r; i++) {
        Arrays.fill(full[i], 'O');
    }
    return full;
}

private static char[][] detonate(char[][] grid, int r, int c) {
    char[][] result = createFullGrid(r, c);
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (grid[i][j] == 'O') {
                result[i][j] = '.';
                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                        result[ni][nj] = '.';
                    }
                }
            }
        }
    }
    return result;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        List<String> result = Result.bomberMan(n, grid);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
