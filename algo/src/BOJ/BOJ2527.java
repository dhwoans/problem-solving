package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 공통부분의 특성	코드 문자
 * 직사각형	        a
 * 선분	            b
 * 점	            c
 * 공통부분이 없음	    d
 */
public class BOJ2527 {//풀이중

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String data =  "7 7 12 12 0 0 10 10";    //a
//
//
//
//        br = new BufferedReader(new StringReader(data));
        int T = 4;
        for (int test_case = 0; test_case < T; test_case++) {
            char answer = '0';
            int[] X = new int[4];
            int[] Y = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = 0;
            int num2 = 0;
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 1) {
                    Y[num1++] = Integer.parseInt(st.nextToken());
                } else {
                    X[num2++] = Integer.parseInt(st.nextToken());
                }
            }
            if ((X[2] == X[1] && Y[2] == Y[1]) || (X[3] == X[0] && Y[3] == Y[0]) || (X[2] == X[1] && Y[3] == Y[0]) || (X[3] == X[0] && Y[2] == Y[1])) {
                System.out.println("c");
            } else if ((X[2] == X[1] && Y[2] != Y[1]) || (X[3] != X[0] && Y[3] == Y[0]) || (X[2] != X[1] && Y[3] == Y[0]) || (X[3] == X[0] && Y[2] != Y[1])) {
                System.out.println("b");
            } else if (X[1] < X[2] || X[3] < X[0] || Y[1] < Y[2] || Y[3] < Y[0]) {
                System.out.println("d");


            } else {
                System.out.println("a");
            }


        }
    }
}

