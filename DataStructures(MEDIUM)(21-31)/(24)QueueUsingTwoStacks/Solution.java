import java.io.*;
import java.util.*;

public class Solution {

    static class MyQueue {
        Stack<Integer> stackNewestOnTop = new Stack<>();
        Stack<Integer> stackOldestOnTop = new Stack<>();

        // Add element to the end of the queue
        public void enqueue(int x) {
            stackNewestOnTop.push(x);
        }

        // Move elements from newest stack to oldest stack if needed
        private void shiftStacks() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }

        // Remove the element at the front of the queue
        public void dequeue() {
            shiftStacks();
            stackOldestOnTop.pop();
        }

        // Print the element at the front of the queue
        public int peek() {
            shiftStacks();
            return stackOldestOnTop.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        MyQueue queue = new MyQueue();

        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int type = Integer.parseInt(input[0]);

            switch (type) {
                case 1: // enqueue
                    int x = Integer.parseInt(input[1]);
                    queue.enqueue(x);
                    break;
                case 2: // dequeue
                    queue.dequeue();
                    break;
                case 3: // print front
                    System.out.println(queue.peek());
                    break;
            }
        }
    }
}
