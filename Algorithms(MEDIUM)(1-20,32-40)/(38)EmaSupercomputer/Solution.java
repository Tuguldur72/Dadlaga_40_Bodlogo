import java.util.*;

public class Solution {

    static class Plus {
        int row, col, armLength;
        Set<String> cells;

        Plus(int row, int col, int armLength) {
            this.row = row;
            this.col = col;
            this.armLength = armLength;
            this.cells = new HashSet<>();
            cells.add(row + "," + col);
            for (int i = 1; i <= armLength; i++) {
                cells.add((row + i) + "," + col);
                cells.add((row - i) + "," + col);
                cells.add(row + "," + (col + i));
                cells.add(row + "," + (col - i));
            }
        }

        int area() {
            return 1 + 4 * armLength;
        }

        boolean overlaps(Plus other) {
            for (String cell : this.cells) {
                if (other.cells.contains(cell)) {
                    return true;
                }
            }
            return false;
        }
    }

    static int twoPluses(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        List<Plus> pluses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxArm = getMaxArmLength(grid, i, j);
                for (int k = 0; k <= maxArm; k++) {
                    pluses.add(new Plus(i, j, k));
                }
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < pluses.size(); i++) {
            Plus p1 = pluses.get(i);
            for (int j = i + 1; j < pluses.size(); j++) {
                Plus p2 = pluses.get(j);
                if (!p1.overlaps(p2)) {
                    int product = p1.area() * p2.area();
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }
        }

        return maxProduct;
    }

    static int getMaxArmLength(String[] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length();
        int maxArm = 0;
        while (true) {
            int len = maxArm + 1;
            if (row - len < 0 || row + len >= n || col - len < 0 || col + len >= m) {
                break;
            }
            if (grid[row - len].charAt(col) != 'G' || grid[row + len].charAt(col) != 'G' ||
                grid[row].charAt(col - len) != 'G' || grid[row].charAt(col + len) != 'G') {
                break;
            }
            maxArm++;
        }
        return maxArm;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.nextLine();
        }
        System.out.println(twoPluses(grid));
        in.close();
    }
}
