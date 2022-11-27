package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * <p>
 * 둘째 줄에는 중앙값을 출력한다.
 * <p>
 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 * <p>
 * 넷째 줄에는 범위를 출력한다.
 */
public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        //숫자 담기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        //산술평균
        int sum = Arrays.stream(arr).sum();
        double mean = (double) sum / n;

        sb.append(Math.round(mean)).append("\n");

        //중앙값
        int median =arr[n/2];

        sb.append(median).append("\n");

        //최빈값
        int[] frequency = new int[8001];
        for (int i : arr) {
            if(i<=0) frequency[Math.abs(i)]++;
            else frequency[i+4000]++;
        }
        int max  = Arrays.stream(frequency).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i]==max){
                int temp = i*-1;
                if(i>4000) temp=i-4000;
                answer.add(temp);
            }
        }
        if(answer.size()==1){
            sb.append(answer.get(0)).append("\n");
        }else{
            Collections.sort(answer);
            sb.append(answer.get(1)).append("\n");
        }

        //최대 최소
        sb.append(arr[n-1]-arr[0]);
        System.out.print(sb);
    }
}
