import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static String timeInWords(int h, int m) {
    String[] nums = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
        "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
        "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    if (m == 0) {
        return nums[h] + " o' clock";
    } else if (m == 15) {
        return "quarter past " + nums[h];
    } else if (m == 30) {
        return "half past " + nums[h];
    } else if (m == 45) {
        return "quarter to " + nums[h + 1];
    } else if (m < 30) {
        return nums[m] + (m == 1 ? " minute past " : " minutes past ") + nums[h];
    } else {
        int minutesTo = 60 - m;
        return nums[minutesTo] + (minutesTo == 1 ? " minute to " : " minutes to ") + nums[h + 1];
    }
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
