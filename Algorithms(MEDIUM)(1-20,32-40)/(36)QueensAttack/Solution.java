import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();     
        int k = in.nextInt();     
        int r_q = in.nextInt();   
        int c_q = in.nextInt();    
        int up = n - r_q;
        int down = r_q - 1;
        int right = n - c_q;
        int left = c_q - 1;
        int upLeft = Math.min(up, left);
        int upRight = Math.min(up, right);
        int downLeft = Math.min(down, left);
        int downRight = Math.min(down, right);

        for (int i = 0; i < k; i++) {
            int r_o = in.nextInt();
            int c_o = in.nextInt();

            if (r_o == r_q) {
                if (c_o < c_q) left = Math.min(left, c_q - c_o - 1);
                else if (c_o > c_q) right = Math.min(right, c_o - c_q - 1);
            }

            else if (c_o == c_q) {
                if (r_o < r_q) down = Math.min(down, r_q - r_o - 1);
                else if (r_o > r_q) up = Math.min(up, r_o - r_q - 1);
            }

            else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) {
                if (r_o > r_q && c_o < c_q)
                    upLeft = Math.min(upLeft, r_o - r_q - 1);
                else if (r_o > r_q && c_o > c_q)
                    upRight = Math.min(upRight, r_o - r_q - 1);
                else if (r_o < r_q && c_o < c_q)
                    downLeft = Math.min(downLeft, r_q - r_o - 1);
                else if (r_o < r_q && c_o > c_q)
                    downRight = Math.min(downRight, r_q - r_o - 1);
            }
        }

        int total = up + down + left + right + upLeft + upRight + downLeft + downRight;
        System.out.println(total);
    }
}
