import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

public static String isValid(String s) {
    Map<Character, Integer> freqMap = new HashMap<Character, Integer>();

    // Count frequency of each character
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (freqMap.containsKey(c)) {
            freqMap.put(c, freqMap.get(c) + 1);
        } else {
            freqMap.put(c, 1);
        }
    }

    // Count frequencies of frequencies
    Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    for (Integer freq : freqMap.values()) {
        if (countMap.containsKey(freq)) {
            countMap.put(freq, countMap.get(freq) + 1);
        } else {
            countMap.put(freq, 1);
        }
    }

    // All frequencies the same
    if (countMap.size() == 1) {
        return "YES";
    }

    // Two different frequencies
    if (countMap.size() == 2) {
        Iterator<Integer> it = countMap.keySet().iterator();
        int freq1 = it.next();
        int freq2 = it.next();
        int count1 = countMap.get(freq1);
        int count2 = countMap.get(freq2);

        if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
            return "YES";
        }

        if ((Math.abs(freq1 - freq2) == 1) && (count1 == 1 || count2 == 1)) {
            return "YES";
        }
    }

    return "NO";
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
