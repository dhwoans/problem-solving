package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 2493.탑
 *
 * stack을 이용
 *
 */
public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer[]> arr = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < T; i++) {
            int n =Integer.parseInt(st.nextToken());
            while (!arr.isEmpty()){
                if(arr.peek()[1]>=n){
                    System.out.print(arr.peek()[0]+" ");
                    break;
                }
                arr.pop();
            }
            if (arr.isEmpty()) {
                System.out.print("0 ");
            }
            arr.push(new Integer[] { i+1, n });
        }

    }
}
