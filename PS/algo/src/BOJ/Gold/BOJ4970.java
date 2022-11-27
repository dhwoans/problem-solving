package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ4970
 * @date : 2022-01-05
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ4970 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        while (true){
            if (str.equals(".")) {
                break;
            }
            str=str.replaceAll("--","");
            str=str.replaceAll("-R","r");
            str=str.replaceAll("-P","p");
            str=str.replaceAll("-Q","q");

            Stack<Character> ch = new Stack<>();


            for (int i = 0; i < str.length(); i++) {
                    if(str.charAt(i)=='('||str.charAt(i)=='+'||str.charAt(i)=='*'){
                        ch.push(str.charAt(i));
                    }else if(str.charAt(i)==')'){
                        while (ch.peek()!='('){
                            sb.append(ch.pop());
                        }
                        ch.pop();
                    }else{
                        sb.append(str.charAt(i));
                    }

            }
            System.out.println(sb);
        }

    }
}
