import java.util.*;

public class Solution {

    static int activityNotifications(int[] expenditure, int d) {
        int[] count = new int[201];
        int notifications = 0;

        // Initialize the count array with the first d expenditures
        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {
            double median = getMedian(count, d);

            if (expenditure[i] >= 2 * median) {
                notifications++;
            }

            // Update the count array
            count[expenditure[i - d]]--;
            count[expenditure[i]]++;
        }

        return notifications;
    }

    static double getMedian(int[] count, int d) {
        int sum = 0;
        if (d % 2 == 1) {
            int medianPos = d / 2 + 1;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (sum >= medianPos) {
                    return i;
                }
            }
        } else {
            int first = -1;
            int second = -1;
            int medianPos1 = d / 2;
            int medianPos2 = medianPos1 + 1;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (first == -1 && sum >= medianPos1) {
                    first = i;
                }
                if (sum >= medianPos2) {
                    second = i;
                    break;
                }
            }
            return (first + second) / 2.0;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for (int i = 0; i < n; i++) {
            expenditure[i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}
