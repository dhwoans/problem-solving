package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_2805_나무 자르기
 * @date : 2021. 12. 12.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 *  랜선 자르기와 비슷
 **/
public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());            // 나무 수
        int M = Integer.parseInt(st.nextToken());            // 가져가려고하는 나무 길이
        int min = 0;                                        // 이분탐색 시작
        int max = 0;                                        // 이분탐색 끝
        int[] arr = new int[N];                             // 나무 길이 저장할 배열


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }


        while (min<max){                                    // upper bound
            long cut=0;                                     // 임의로 자른 나무
        int mid = (max+min)/2;                              // 이분탐색 중간

            for (int i : arr) {
                if(i>mid) cut+=i-mid;
            }

            if(cut< M){
                max=mid;
            }else{
                min=mid+1;
            }


        }
        System.out.println(min-1);
    }
}
