package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1018.체스판 다시 칠하기
 *
 * 2차원 배열 문제
 *
 * 4중 for문을 이용해서 일치여부 확인
 *
 */

public class BOJ1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        char[][] chess1 ={{'W','B','W','B','W','B','W','B'},
                         {'B','W','B','W','B','W','B','W'},
                         {'W','B','W','B','W','B','W','B'},
                         {'B','W','B','W','B','W','B','W'},
                         {'W','B','W','B','W','B','W','B'},
                         {'B','W','B','W','B','W','B','W'},
                         {'W','B','W','B','W','B','W','B'},
                         {'B','W','B','W','B','W','B','W'}};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j]=str.charAt(j);
            }
        }
        //검사
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <= map.length-chess1.length; i++) {
            for (int j = 0; j <= map[i].length-chess1.length; j++) {
            int count1= 0;
                for (int k = 0; k < chess1.length; k++) {
                    for (int l = 0; l < chess1.length; l++) {
                        if(chess1[k][l]!=map[k+i][l+j]){count1++;}
                    }
                }
                int temp = Math.min(count1,64-count1);
                min=Math.min(min,temp);
            }
        }
        System.out.println(min);
    }
}
