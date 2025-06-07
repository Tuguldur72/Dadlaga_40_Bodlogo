import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        final int MAX_KEY = 100;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<String>> buckets = new ArrayList<>(MAX_KEY);
        for (int i = 0; i < MAX_KEY; i++) {
            buckets.add(new ArrayList<String>());
        }

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int key = Integer.parseInt(parts[0]);
            String value = (i < n / 2) ? "-" : parts[1];
            buckets.get(key).add(value);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (List<String> bucket : buckets) {
            for (String val : bucket) {
                sb.append(val).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
