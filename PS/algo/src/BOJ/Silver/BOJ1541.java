package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        // 나누기
        ArrayList<String> arr = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            arr.add(temp);
        }
        // 더하기
        Queue<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            int sum = 0;
            st = new StringTokenizer(arr.get(i),"+");
            while (st.hasMoreTokens()){
                sum += Integer.parseInt(st.nextToken());
            }
            stack.add(sum);

        }
        int answer = stack.poll();
        while (!stack.isEmpty()){
            answer -= stack.poll();
        }
        System.out.println(answer);
    }

}

