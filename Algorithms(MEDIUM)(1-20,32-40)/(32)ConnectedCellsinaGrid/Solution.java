import java.io.*;
import java.util.*;

public class Solution {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        grid = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        int maxRegion = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int regionSize = dfs(i, j);
                    maxRegion = Math.max(maxRegion, regionSize);
                }
            }
        }
        
        System.out.println(maxRegion);
    }
    
    static int dfs(int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        int size = 1;
        
        // Explore all 8 possible directions
        size += dfs(i-1, j-1);
        size += dfs(i-1, j);
        size += dfs(i-1, j+1);
        size += dfs(i, j-1);
        size += dfs(i, j+1);
        size += dfs(i+1, j-1);
        size += dfs(i+1, j);
        size += dfs(i+1, j+1);
        
        return size;
    }
}