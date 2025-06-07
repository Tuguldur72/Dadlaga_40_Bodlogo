import java.util.*;

public class Solution {

    static String organizingContainers(int[][] container) {
        int n = container.length;
        int[] rowSum = new int[n];  
        int[] colSum = new int[n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += container[i][j];
                colSum[j] += container[i][j];
            }
        }

        Arrays.sort(rowSum);
        Arrays.sort(colSum);

        for (int i = 0; i < n; i++) {
            if (rowSum[i] != colSum[i])
                return "Impossible";
        }

        return "Possible";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt(); 

        while (q-- > 0) {
            int n = in.nextInt();
            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    container[i][j] = in.nextInt();

            System.out.println(organizingContainers(container));
        }
        in.close();
    }
}
