package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expert5603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {


            int size = Integer.parseInt(br.readLine());
            int sum = 0;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];

            }
            sum /= size;
            int answer = 0;
            for (int i : arr) {
                answer += Math.abs(sum - i);
            }
            System.out.println("#" + test_case+" "+(answer/2));
        }
    }
}
