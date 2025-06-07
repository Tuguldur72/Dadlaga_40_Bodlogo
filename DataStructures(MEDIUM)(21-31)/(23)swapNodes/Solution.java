import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    int n = indexes.size();
    List<List<Integer>> result = new ArrayList<>();

    final List<List<Integer>> finalIndexes = indexes; // fix for inner class access

    // Recursive function to swap at given depths multiple of k
    class Helper {
        void swapAtDepth(int node, int depth, int k) {
            if (node == -1) return;

            // If depth is multiple of k, swap children
            if (depth % k == 0) {
                List<Integer> children = finalIndexes.get(node - 1);
                int left = children.get(0);
                int right = children.get(1);
                children.set(0, right);
                children.set(1, left);
            }

            // Recurse for children
            List<Integer> children = finalIndexes.get(node - 1);
            swapAtDepth(children.get(0), depth + 1, k);
            swapAtDepth(children.get(1), depth + 1, k);
        }

        void inOrder(int node, List<Integer> traversal) {
            if (node == -1) return;
            List<Integer> children = finalIndexes.get(node - 1);
            inOrder(children.get(0), traversal);
            traversal.add(node);
            inOrder(children.get(1), traversal);
        }
    }

    Helper helper = new Helper();

    for (int k : queries) {
        helper.swapAtDepth(1, 1, k);
        List<Integer> traversal = new ArrayList<>();
        helper.inOrder(1, traversal);
        result.add(traversal);
    }

    return result;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] indexesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> indexesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int indexesItem = Integer.parseInt(indexesRowTempItems[j]);
                indexesRowItems.add(indexesItem);
            }

            indexes.add(indexesRowItems);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

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
