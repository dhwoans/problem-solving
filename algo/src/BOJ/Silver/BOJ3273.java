package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_2003_두수의 합
 * @date : 2021. 12. 02.
 * @language : JAVA
 * @classification : two pointer
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 *
 **/
public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        //값 입력받기
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int sum = 0;
        int start = 0;
        int end =n-1;
        int answer =0;
        while (start<end){
            sum = arr[start]+arr[end];
            if(sum==m){
               start++;
               end--;
               answer++;
            }
            else if(sum>m){
                end--;
            }else{
                start++;
            }

        }
        System.out.println(answer);

    }
}
