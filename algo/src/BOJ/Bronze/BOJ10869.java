package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10860.사칙연산
 *
 * 그냥 풀면됨
 */
public class BOJ10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 =Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        System.out.println(num1+num2);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        System.out.println(num1/num2);
        System.out.println(num1%num2);
    }
}
