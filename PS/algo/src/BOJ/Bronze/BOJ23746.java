package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Bronze
 * @fileName : BOJ23746
 * @date : 2021-12-18
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description : 문자열 관련 메소드 이용
 **/
public class BOJ23746 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());            //압축 방법 개수
        String compressedString="";                         //압축된 문자열
        int S=0;                                            //처음 인덱스
        int E=0;                                            //마지막 인덱스
        String answer ="";
        ArrayList<String[]> arr = new ArrayList<>();        //문자열 담는 곳

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] str = new String[2];
            str[0] = st.nextToken();                        //소문자 문자열 패턴
            str[1] = st.nextToken();                        //대응 되는 대문자

            arr.add(str);
        }
        compressedString = br.readLine();

        /*
         * 문자열 압축푸는 작업
         */
        for (String[] a : arr) {
            compressedString = compressedString.replace(a[1], a[0]);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        answer = compressedString.substring(S-1,E);        //문자열 자르기
        System.out.println(answer);
    }
}

