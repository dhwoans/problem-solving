package BOJ.Silver;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_1654_랜선 자르기
 * @date : 2021. 12. 11.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());  //가지고 있는 랜선개수
        int N = Integer.parseInt(st.nextToken()); //필요한 랜선개수
        int[] arr = new int[K];
        long start = 0;
        long end = 0;
        long mid=0; //랜선 나눌 임의의 값
        long cable = 0; // 임의의 값으로 자른 랜선개수

        //값 입력
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        end++;


        while (start<end){                      //이분 탐색(upper)
            cable=0;
            mid = (start+end)/2;

            for (int i : arr) {
                cable += (i/mid);
            }

            if(N <= cable){
                start = mid+1;
            }else{
                end=mid;
            }
        }
        System.out.println(start-1);
    }
}
