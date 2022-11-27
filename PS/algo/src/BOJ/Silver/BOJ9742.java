package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9742 {
    static char[] input;
    static boolean[] visit;
    static char[] arr;
    static ArrayList<char[]> answer;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {


            StringTokenizer st = new StringTokenizer(s);
            String str = st.nextToken();
            int index = Integer.parseInt(st.nextToken());
            input = new char[str.length()];
            visit = new boolean[str.length()];
            arr = new char[str.length()];
            answer = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                input[i] = str.charAt(i);
            }
            DFS(0);
            System.out.print(str + " " + index + " =" + " ");
            if(answer.size()<index-1){
                System.out.print("No permutation");
                System.out.println();
                continue;
            }
            for (int i : answer.get(index - 1)) {

                System.out.print((char) i);
            }
            System.out.println();

        }
    }

    static void DFS(int cnt) {
        if (cnt == input.length) {
            char[] temp = Arrays.copyOf(arr, arr.length);
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
