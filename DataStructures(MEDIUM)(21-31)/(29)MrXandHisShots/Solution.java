import java.util.*;
import java.io.*;

class Result {

    public static int solve(List<List<Integer>> shots, List<List<Integer>> players) {
        int n = shots.size();
        int m = players.size();
        
        // Extract and sort the A_i and B_i arrays
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = shots.get(i).get(0);
            B[i] = shots.get(i).get(1);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        
        int total = 0;
        
        for (List<Integer> player : players) {
            int C = player.get(0);
            int D = player.get(1);
            
            // Number of shots with A_i <= D
            int countA = upperBound(A, D);
            
            // Number of shots with B_i < C
            int countB = lowerBound(B, C);
            
            int overlaps = countA - countB;
            total += overlaps;
        }
        
        return total;
    }
    
    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> shots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] shotsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> shotsRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int shotsItem = Integer.parseInt(shotsRowTempItems[j]);
                shotsRowItems.add(shotsItem);
            }

            shots.add(shotsRowItems);
        }

        List<List<Integer>> players = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] playersRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> playersRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int playersItem = Integer.parseInt(playersRowTempItems[j]);
                playersRowItems.add(playersItem);
            }

            players.add(playersRowItems);
        }

        int result = Result.solve(shots, players);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}