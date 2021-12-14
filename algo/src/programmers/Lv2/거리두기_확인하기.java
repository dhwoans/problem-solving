package programmers.Lv2;

import java.util.Scanner;

public class 거리두기_확인하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] placese = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = new int[5];
        int aa=0;
        for (int a = 0; a < 5; a++) {


            char[][] map = new char[5][5];
            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};//상하좌우 상좌 상우 하좌 하우
            int[][] dir2 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상 하 좌 우
            int nc;
            int nr;
            boolean flag = true;
            //배열담기
            for (int z = 0; z < placese.length; z++) {
                String str = placese[a][z];
                for (int s = 0; s < map.length; s++) {
                    map[z][s]=str.charAt(s);
                }
            }

            //p이면 8방 탐색 ㄱㄱ
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map.length; c++) {
                    if (map[r][c] == 'P') {

                        for (int o = 0; o < 8; o++) {
                            nr = r + dir[o][0];
                            nc = c + dir[o][1];

                            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) continue;

                            if (map[nr][nc] == 'P') {
                                for (int i = 0; i < 4; i++) {
                                    int nr1 = r+dir[i][0];
                                    int nc1 = c+dir[i][1];

                                    if (nr1 < 0 || nc1 < 0 || nr1 >= map.length || nc1 >= map.length) continue;
                                    if(map[nr1][nc1]=='X'){break;
                                    }
                                        flag = false;
                                    break;
                                }


                            }


                        }
                        for (int i = 0; i < 4; i++) {
                            int nr2 = r + dir2[i][0];
                            int nc2 = c + dir2[i][1];
                            nr = r + dir[i][0];
                            nc = c + dir[i][0];

                            if (nr2 < 0 || nc2 < 0 || nr2 >= map.length || nc2 >= map.length) continue;

                            if (map[nr2][nc2] == 'P') {
                                if (map[nr][nc] != 'X') {
                                    flag = false;
                                    break;

                                }


                            }
                        }

                    }
                }
            }

            if (flag) {

                answer[aa]=1;
                aa++;
            } else {
               answer[aa]=0;
               aa++;
            }
        }
        for(int x:answer){
            System.out.println(x);
        }
    }
}