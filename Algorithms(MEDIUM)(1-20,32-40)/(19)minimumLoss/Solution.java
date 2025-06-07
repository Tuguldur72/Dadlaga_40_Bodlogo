import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

public static int minimumLoss(List<Long> price) {
    int n = price.size();
    List<Pair> priceWithIndex = new ArrayList<Pair>();

    for (int i = 0; i < n; i++) {
        priceWithIndex.add(new Pair(price.get(i), i));
    }

    // Sort in descending order using Comparator
    Collections.sort(priceWithIndex, new Comparator<Pair>() {
        public int compare(Pair a, Pair b) {
            return Long.compare(b.value, a.value); // Descending
        }
    });

    long minLoss = Long.MAX_VALUE;

    for (int i = 0; i < n - 1; i++) {
        Pair buy = priceWithIndex.get(i);
        Pair sell = priceWithIndex.get(i + 1);
        if (buy.index < sell.index) {
            minLoss = Math.min(minLoss, buy.value - sell.value);
        }
    }

    return (int) minLoss;
}

static class Pair {
    long value;
    int index;

    Pair(long value, int index) {
        this.value = value;
        this.index = index;
    }
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] priceTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> price = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceTemp[i]);
            price.add(priceItem);
        }

        int result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
