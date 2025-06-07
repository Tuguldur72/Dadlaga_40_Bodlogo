import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'hackerlandRadioTransmitters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER k
     */

public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
    Collections.sort(x);
    int n = x.size();
    int i = 0;
    int transmitters = 0;

    while (i < n) {
        transmitters++;

        int loc = x.get(i) + k;
        while (i < n && x.get(i) <= loc) {
            i++;
        }

        int antenna = x.get(i - 1);

        loc = antenna + k;
        while (i < n && x.get(i) <= loc) {
            i++;
        }
    }

    return transmitters;
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] xTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> x = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xTemp[i]);
            x.add(xItem);
        }

        int result = Result.hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
