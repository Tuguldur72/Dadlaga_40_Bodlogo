import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    List<Integer> results = new ArrayList<Integer>();
    Map<String, Integer> frequencyMap = new HashMap<String, Integer>();

    // Count the occurrences of each string in stringList
    for (String s : stringList) {
        if (frequencyMap.containsKey(s)) {
            frequencyMap.put(s, frequencyMap.get(s) + 1);
        } else {
            frequencyMap.put(s, 1);
        }
    }

    // For each query, get the count from the map (or 0 if not found)
    for (String query : queries) {
        if (frequencyMap.containsKey(query)) {
            results.add(frequencyMap.get(query));
        } else {
            results.add(0);
        }
    }

    return results;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < stringListCount; i++) {
            String stringListItem = bufferedReader.readLine();
            stringList.add(stringListItem);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = bufferedReader.readLine();
            queries.add(queriesItem);
        }

        List<Integer> res = Result.matchingStrings(stringList, queries);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
