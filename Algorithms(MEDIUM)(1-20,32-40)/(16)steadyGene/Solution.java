import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */

public static int steadyGene(String gene) {
    int n = gene.length();
    int required = n / 4;
    Map<Character, Integer> count = new HashMap<>();

    for (int i = 0; i < n; i++) {
        char c = gene.charAt(i);
        if (count.containsKey(c)) {
            count.put(c, count.get(c) + 1);
        } else {
            count.put(c, 1);
        }
    }

    if (isSteady(count, required)) return 0;

    int minLength = n;
    int left = 0;

    for (int right = 0; right < n; right++) {
        char rc = gene.charAt(right);
        count.put(rc, count.get(rc) - 1);

        while (isSteady(count, required)) {
            minLength = Math.min(minLength, right - left + 1);
            char lc = gene.charAt(left);
            count.put(lc, count.get(lc) + 1);
            left++;
        }
    }

    return minLength;
}

private static boolean isSteady(Map<Character, Integer> count, int required) {
    int a = count.containsKey('A') ? count.get('A') : 0;
    int c = count.containsKey('C') ? count.get('C') : 0;
    int g = count.containsKey('G') ? count.get('G') : 0;
    int t = count.containsKey('T') ? count.get('T') : 0;

    return a <= required && c <= required && g <= required && t <= required;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String gene = bufferedReader.readLine();

        int result = Result.steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
