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
public class BOJ18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        //값 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int[] temp = Arrays.copyOf(arr, arr.length);
        int count = 0;
        Arrays.sort(temp);
        for (int i : temp) {
            if (map.get(i) == null) {
                map.put(i, count++);
            }
        }

        for (int i : arr) {
            sb.append(map.get(i) + " ");
        }
        System.out.println(sb);
    }
}
