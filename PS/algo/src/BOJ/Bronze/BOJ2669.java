package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * 입력은 네 줄이며, 각 줄은 직사각형의 위치를 나타내는 네 개의 정수로 주어진다.
 * 첫 번째와 두 번째의 정수는 사각형의 왼쪽 아래 꼭짓점의 x좌표, y좌표이고
 * 세 번째와 네 번째의 정수는 사각형의 오른쪽 위 꼭짓점의 x좌표, y좌표이다.
 * 모든 x좌표와 y좌표는 1이상이고 100이하인 정수이다.
 *
 *
 */
public class BOJ2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        String data  =
//                "1 2 4 4\n" +
//                "2 3 5 7\n" +
//                "3 1 6 5\n" +
//                "7 3 8 6";
//        br = new BufferedReader(new StringReader(data));
        int T = 4;
        int[][] map = new int[100][100];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());


            int x2= Integer.parseInt(st.nextToken());
            int y2 =Integer.parseInt(st.nextToken());
            for (int j = y1; j <y2 ; j++) {
                for (int k = x1; k < x2; k++) {
                    if(map[j][k]==0)
                    map[j][k]=1;
                }

            }
        }
        int count   =0;
        for (int[] ints : map) {
            for (int anInt : ints) {
                if(anInt==1){
                    count++;
                }
            }
        }
        System.out.println(count);


    }
}
