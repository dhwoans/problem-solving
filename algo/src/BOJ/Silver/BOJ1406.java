package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1406.에디터
 *
 * 참신했다.
 */
public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> right = new Stack<>();
        Stack<Character> left = new Stack<>();

        String start=br.readLine();
        for (int i = 0; i < start.length(); i++) {
            left.push(start.charAt(i));
        }
        //명령
        int command = Integer.parseInt(br.readLine());
        for (int i = 0; i < command; i++) {
            String alpha = br.readLine();
            switch (alpha.charAt(0)){
                case 'L':
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    break;
                case 'P':
                    StringTokenizer st = new StringTokenizer(alpha);
                    String p=st.nextToken();
                    String ch = st.nextToken();
                    left.push(ch.charAt(0));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        left.stream().forEach(character -> sb1.append(character));
        right.stream().forEach(character -> sb.append(character));
        System.out.print(sb1);
        System.out.print(sb.reverse());



    }
}
