package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int base=Integer.parseInt(st.nextToken());
            int exponent = Integer.parseInt(st.nextToken());
            //일의 자리는 반복적으로  같은 숫자가 나옴
            exponent%=4;
            if(exponent==0) exponent=4;
            int value = (int)(Math.pow(base,exponent));
            //일의 자리 구하기 위해 string으로
            String str = Integer.toString(value);
            int answer = Character.getNumericValue(str.charAt(str.length()-1));
            //0은 10번째 컴퓨터에 저장
            if(answer== 0) answer =10;
            System.out.println(answer);

        }
    }
}
