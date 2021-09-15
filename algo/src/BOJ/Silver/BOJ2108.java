package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

/**
 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * <p>
 * 둘째 줄에는 중앙값을 출력한다.
 * <p>
 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 * <p>
 * 넷째 줄에는 범위를 출력한다.
 */
public class BOJ2108 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int num = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        double sum1=0;
        //배열담기
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);
            min = Math.min(min, num);

            arr[i] = num;
            sum1+=num;
        }
        Arrays.sort(arr);

        //산술평균
        double avg = 0;

        avg = sum1/N;
        sb.append(Math.round(avg)+"\n");
        //중앙값
        int center = 0;
        center = arr[N / 2];
        sb.append(center+"\n");
        //최빈값
        int[] many = new int[8001];
        for (int i : arr) {
            many[i+4000]++;
        }

        int max3= Integer.MIN_VALUE;
        for (int i : many) {
            if(i>max3){
                max3=i;
            }
        }
        ArrayList<Integer> same = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < many.length; i++) {
            if(many[i]==0)continue;
            if(many[i]==max3){
                same.add(i-4000);

            }
        }
        same.sort((o1, o2) -> o1-o2);
        answer= same.get(1);
        sb.append(answer+"\n");
        //범위
            int rang = arr[N - 1] - arr[0];
            sb.append(rang);

        System.out.printf(sb.toString());

    }
}
