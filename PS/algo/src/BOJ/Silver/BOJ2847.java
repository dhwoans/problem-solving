package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        //점수 정보
        for (int i = 0; i < n; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        var count = 0;
        var score = stack.pop();
        while(!stack.isEmpty()){
           var cnt = stack.pop();
           if(score<=cnt){
               count+=(cnt-score)+1;
               score =score-1;
           }else{
               score=cnt;
           }
        }

        System.out.println(count);
    }
}
