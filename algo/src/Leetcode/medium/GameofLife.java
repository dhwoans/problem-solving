package Leetcode.medium;


public class GameofLife {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};

    public int[][] gameOfLife(int[][] board) {
        boolean[][] check = new boolean[board.length][board[0].length]; // f 유지 t 변경

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                check(board, check, i, j, board[i][j]);
            }
        }

        //변경
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[i].length; j++) {
                if (check[i][j]) {
                    if (board[i][j] == 1) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                }
            }
        }

        return board;
    }

    private void check(int[][] board, boolean[][] check, int x, int y, int val) {
        if (val == 1) {
            int count = getCount(x, y, board);
            if (count < 2 || count > 3) check[x][y] = true;
        } else {
            int count = getCount(x, y, board);
            if (count == 3) check[x][y] = true;

        }
    }

    private int getCount(int x, int y, int[][] board) {
        //8방탐색
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            if (board[nx][ny] == 1) {
                count++;
            }
        }
        return count;
    }
}
