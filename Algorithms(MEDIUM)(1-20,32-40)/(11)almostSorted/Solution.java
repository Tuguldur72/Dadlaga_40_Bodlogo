import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static void almostSorted(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        int l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (!arr.get(i).equals(sorted.get(i))) {
                if (l == -1) l = i;
                r = i;
            }
        }

        if (l == -1) {
            System.out.println("yes");
        } else {
            List<Integer> swapped = new ArrayList<>(arr);
            Collections.swap(swapped, l, r);
            if (swapped.equals(sorted)) {
                System.out.println("yes");
                System.out.println("swap " + (l + 1) + " " + (r + 1));
                return;
            }

            List<Integer> reversed = new ArrayList<>(arr);
            List<Integer> sub = reversed.subList(l, r + 1);
            Collections.reverse(sub);
            if (reversed.equals(sorted)) {
                System.out.println("yes");
                System.out.println("reverse " + (l + 1) + " " + (r + 1));
                return;
            }

            System.out.println("no");
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
