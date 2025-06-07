import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        long result = 0;
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            while (!stack.isEmpty() && stack.peek().height < current) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek().height == current) {
                result += stack.peek().count;
                stack.peek().count++;
            } else {
                stack.push(new Pair(current, 1));
            }
        }

        System.out.println(result * 2);
    }

    static class Pair {
        int height;
        int count;

        Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}