package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : BOJ.Bronze
 * @fileName : BOJ2775
 * @date : 2021-12-18
 * @language : JAVA
 * @classification :
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description : 재귀를 이용
 **/
public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());            //testcase

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());       //층
            int n = Integer.parseInt(br.readLine());       //호

           int result = getpeople(k,n);
            System.out.println(result);
        }
    }

    private static int getpeople(int k,int n) {
        int sum =0;
        if(k==0){
            return n;
        }
        for (int i = 1; i <= n; i++) {
            sum += getpeople(k-1,i);
        }
        return sum;
    }
}
