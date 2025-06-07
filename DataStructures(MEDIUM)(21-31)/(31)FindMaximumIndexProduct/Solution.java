import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n+1]; // 1-based indexing
        for(int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        Stack<Integer> stack = new Stack<>();
        
        // Find left closest index for each element
        for(int i = 1; i <= n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        // Find right closest index for each element
        for(int i = n; i >= 1; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        
        long maxProduct = 0;
        for(int i = 1; i <= n; i++) {
            long product = (long)left[i] * (long)right[i];
            if(product > maxProduct) {
                maxProduct = product;
            }
        }
        
        System.out.println(maxProduct);
    }
}