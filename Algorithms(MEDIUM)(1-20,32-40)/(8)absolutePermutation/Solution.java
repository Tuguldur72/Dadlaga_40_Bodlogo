import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static List<Integer> absolutePermutation(int n, int k) {
    List<Integer> result = new ArrayList<>();

    if (k == 0) {
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }
        return result;
    }

    if (n % (2 * k) != 0) {
        result.add(-1);
        return result;
    }

    boolean add = true;
    for (int i = 1; i <= n; i++) {
        if (add) {
            result.add(i + k);
        } else {
            result.add(i - k);
        }

        if (i % k == 0) {
            add = !add;
        }
    }

    return result;
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> result = Result.absolutePermutation(n, k);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
