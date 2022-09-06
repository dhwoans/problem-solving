package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {val,i,0};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            arr[i][2]=i;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][2]+" ");
        }
    }
}
