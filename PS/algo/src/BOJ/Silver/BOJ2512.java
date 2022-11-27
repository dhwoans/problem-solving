package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_2512_예산
 * @date : 2021. 12. 13.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description upper bound
 **/

public class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());                    // 지방의 수
        int budget = 0;                                             // 총 예산
        int[] arr = new int[N];                                     // 예산 요청
        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        max++;

        budget = Integer.parseInt(br.readLine());

        while (min < max) {
            int result = 0;
            int mid = (min + max) / 2;

            for (int i : arr) {
                if(i<mid){
                    result+=i;
                }else{
                    result+=mid;
                }
            }

            if(result<=budget){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        System.out.println(min-1);
    }
}
