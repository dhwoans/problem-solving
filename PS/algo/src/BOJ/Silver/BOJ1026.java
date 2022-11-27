package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] A = new int[len];
        Integer[] B = new Integer[len];
        //값 입력받기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < A.length; i++) {
            A[i]=Integer.parseInt(st1.nextToken());
            B[i]=Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B,Collections.reverseOrder());

        int answer=0;
        for (int i = 0; i < len; i++) {
            answer+=A[i]*B[i];
        }

        System.out.println(answer);
    }
}
