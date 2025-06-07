import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int prefixCount = 0;
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> results = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (List<String> query : queries) {
            String operation = query.get(0);
            String argument = query.get(1);

            if (operation.equals("add")) {
                addContact(root, argument);
            } else if (operation.equals("find")) {
                results.add(findPartial(root, argument));
            }
        }
        return results;
    }

    private static void addContact(TrieNode root, String name) {
        TrieNode current = root;
        for (char ch : name.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.prefixCount++;
        }
    }

    private static int findPartial(TrieNode root, String partial) {
        TrieNode current = root;
        for (char ch : partial.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return 0;
            }
            current = current.children[index];
        }
        return current.prefixCount;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        for (int i = 0; i < queriesRows; i++) {
            queries.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        List<Integer> result = Result.contacts(queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
