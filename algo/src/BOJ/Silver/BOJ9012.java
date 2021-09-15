package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Stack<Character> ch = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(!ch.isEmpty()&&str.charAt(j)==')'){
                    if(ch.peek()=='('){
                        ch.pop();
                    }
                }else{
                    ch.push(str.charAt(j));
                }
            }
            String answer = "NO";
            if(ch.isEmpty()){
                answer = "YES";
            }
            System.out.println(answer);
        }
    }
}
