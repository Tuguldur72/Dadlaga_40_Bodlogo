import java.io.*;
import java.util.*;

public class Solution {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        
        long[] single = new long[26];
        long[][] pair = new long[26][26];
        long[] triple = new long[26];
        long result = 0;
        
        for (char c : s.toCharArray()) {
            int current = c - 'a';
            
            // Add to result: count of triples that can form a palindrome with this character
            result = (result + triple[current]) % MOD;
            
            // Update triples: for each existing pair, we can form a triple with this character
            for (int i = 0; i < 26; i++) {
                triple[i] = (triple[i] + pair[i][current]) % MOD;
            }
            
            // Update pairs: for each existing single, we can form a pair with this character
            for (int i = 0; i < 26; i++) {
                pair[i][current] = (pair[i][current] + single[i]) % MOD;
            }
            
            // Update single count
            single[current]++;
        }
        
        System.out.println(result);
    }
}