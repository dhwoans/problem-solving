package BOJ;


import java.util.Scanner;

public class BOJ2615 {
    static int[][] map = new int[19][19];
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data =
                        "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n" +
                                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
        sc = new Scanner(data);
        count = 0;
        boolean flag = true;
        //배열담기
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        //탐색
        out:
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    search(i, j, map[i][j]);
                    if (count == 5) {
                        flag = false;
                        System.out.println(1);
                        System.out.println((i + 1) + " " + (j + 1));
                        break out;
                    }


                }

            }

        }
        if (flag) {
            System.out.println(0);
        }

    }

    static void search(int r, int c, int color) {
        int dir[][] = {{1, 0},{0, 1},{-1,-1},{-1, 1}, {1, -1}, {1, 1}};

        count++;
        for (int k = 0; k < 8; k++) {
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            //범위
            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) continue;

            if (map[nr][nc] == color) {

                do {
                    count++;
                    nr += dir[k][0];
                    nc += dir[k][0];
                } while (map[nr][nc] == color);
                map[nr][nc]=0;

            }
        }

        return;
    }
}

