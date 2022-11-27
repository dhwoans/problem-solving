package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        int size = 0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();

            switch (commend) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    arr[size++] = num;
                    break;
                case "pop":
                    if (size == 0) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arr[0]);
                        size--;
                        arr = Arrays.copyOfRange(arr, 1, arr.length);
                    }
                    break;
                case "size":
                    System.out.println(size);
                    break;
                case "empty":
                    int answer = 0;
                    if (size == 0) {
                        answer=1;
                    }
                    System.out.println(answer);
                    break;
                case "front":
                    if (size == 0) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arr[0]);
                    }
                    break;
                case "back":
                    if (size == 0) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arr[size-1]);
                    }
                    break;
            }
        }
    }
}
