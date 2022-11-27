package Leetcode.medium;


public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// 우 하 좌 상
        int point = 0;
        int x = 0;
        int y = 0;
        int num = 1;
        int count = 0;
        int end = n * n;
        arr[0][0] = num;
        while (num != end) {
            x += dir[point][0];
            y += dir[point][1];
            if (x < 0 || y < 0 || x >= n || y >= n||arr[x][y]!=0) {
                x -= dir[point][0];
                y -= dir[point][1];
                point++;
                if (point > 3) {
                    point = 0;
                }

            } else if (arr[x][y] == 0) {
                arr[x][y] = ++num;
            }
        }
        return arr;
    }
}
