import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

   public static String encryption(String s) {
    s = s.replaceAll(" ", "");
    int L = s.length();

    int rows = (int) Math.floor(Math.sqrt(L));
    int cols = (int) Math.ceil(Math.sqrt(L));
    
    if (rows * cols < L) {
        rows++;
    }

    StringBuilder encrypted = new StringBuilder();

    for (int c = 0; c < cols; c++) {
        for (int r = 0; r < rows; r++) {
            int index = r * cols + c;
            if (index < L) {
                encrypted.append(s.charAt(index));
            }
        }
        encrypted.append(" ");
    }

    return encrypted.toString().trim();
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
