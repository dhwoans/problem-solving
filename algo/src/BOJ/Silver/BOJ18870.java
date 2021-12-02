package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_18870_좌표 압축
 * @date : 2021. 11. 30.
 * @language : JAVA
 * @classification : sort
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description counting sort
 **/
public class BOJ18870 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        //입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            int num=Integer.parseInt(st.nextToken());
            arr[i]=num;
            set.add(num);
        }
        ArrayList<Object> nums = new ArrayList<>(set);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(nums.indexOf(i)).append(" ");
        }
        System.out.println(sb);

    }
}
