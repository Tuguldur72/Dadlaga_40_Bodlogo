import java.util.*;

public class Solution {

    static int countLuck(char[][] matrix, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return dfs(matrix, visited, startX, startY, endX, endY);
    }

    static int dfs(char[][] matrix, boolean[][] visited, int x, int y, int endX, int endY) {
        if (x == endX && y == endY) return 0;

        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        List<int[]> nextSteps = new ArrayList<int[]>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length
                    && matrix[nx][ny] != 'X' && !visited[nx][ny]) {
                nextSteps.add(new int[]{nx, ny});
            }
        }

        for (int[] step : nextSteps) {
            int res = dfs(matrix, visited, step[0], step[1], endX, endY);
            if (res != -1) {
                // Хэрвээ одоогийн байрлалд олон зам байвал энэ нь "шийдвэр гаргах мөч"
                return res + (nextSteps.size() > 1 ? 1 : 0);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            char[][] matrix = new char[n][m];
            int startX = 0, startY = 0, endX = 0, endY = 0;
            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = line.charAt(j);
                    if (matrix[i][j] == 'M') {
                        startX = i;
                        startY = j;
                    } else if (matrix[i][j] == '*') {
                        endX = i;
                        endY = j;
                    }
                }
            }
            int k = in.nextInt();
            int result = countLuck(matrix, startX, startY, endX, endY);
            System.out.println(result == k ? "Impressed" : "Oops!");
        }
        in.close();
    }
}
