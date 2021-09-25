package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9742 {
    static int[] input;
    static char[] input1;
    static boolean[] visit;
    static int[] arr;
    static ArrayList<int[]> answer;

    public static void main(String[] args) throws IOException {
        //테스트 케이스 받기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int index = Integer.parseInt(st.nextToken());
        input = new int[str.length()];
        input1 = new char[str.length()];
        visit = new boolean[str.length()];
        arr = new int[str.length()];
        answer = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            input[i] = Character.getNumericValue(str.charAt(i));
        }
        DFS(0);
        System.out.print(str + " " + index + " =" + " ");
        for (int i : answer.get(index - 1)) {
            System.out.print(i);
        }


    }

    static void DFS(int cnt) {
        if (cnt == input.length) {
            int[] temp = Arrays.copyOf(arr, arr.length);
            answer.add(temp);

            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (visit[i]) continue;
            arr[cnt] = input[i];
            visit[i] = true;
            DFS(cnt + 1);
            visit[i] = false;
        }
    }
}
