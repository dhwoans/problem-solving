package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_10816_숫자 카드2
 * @date : 2021. 12. 11.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/

public class BOJ10816 {
    static int[] arr;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < m; i++) {

            int target = Integer.parseInt(st.nextToken());


            int upper = upper_bound(target);
            int lower = lower_bound(target);

            if(upper==lower){
                sb.append(0+" ");
            }else{
                sb.append(upper-lower+" ");
            }
        }
        System.out.println(sb);
    }

    private static int upper_bound(int target) {

        int end = arr.length;
        int start = 0;


        while (start < end) {

            int len = (end + start) / 2;

            if (target >= arr[len]) {
                start = len+1;
            } else {
                end = len;
            }
        }
        return end;
    }

    private static int lower_bound(int target) {

        int end = arr.length;
        int start = 0;


        while (start < end) {

            int len = (end + start) / 2;

            if (target <= arr[len]) {
                end = len;
            } else {
                start = len + 1 ;
            }
        }
        return end;
    }
}
