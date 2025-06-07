import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(reader.readLine());

        StringBuilder S = new StringBuilder();
        Deque<String> history = new ArrayDeque<>();

        for (int i = 0; i < Q; i++) {
            String[] parts = reader.readLine().split(" ");
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1:
                    // append(W)
                    history.push(S.toString()); // save current state
                    S.append(parts[1]);
                    break;
                case 2:
                    // delete(k)
                    history.push(S.toString()); // save current state
                    int k = Integer.parseInt(parts[1]);
                    S.delete(S.length() - k, S.length());
                    break;
                case 3:
                    // print(k)
                    int pos = Integer.parseInt(parts[1]);
                    System.out.println(S.charAt(pos - 1));
                    break;
                case 4:
                    // undo()
                    if (!history.isEmpty()) {
                        S = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
    }
}
