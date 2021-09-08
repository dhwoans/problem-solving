package exD4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Expert1224 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1224.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            Stack<Character> sign = new Stack<>();
            Stack<Character> bracket = new Stack<>();

            //후위식으로 변환
            for (int i = 1; i < str.length()-1; i++) {

                if (str.charAt(i) == '(') {
                    while (str.charAt(i) != ')') {
                        i++;
                        char ch1 = str.charAt(i);
                        switch (ch1) {
                            case '+':
                                if(bracket.isEmpty()){
                                    bracket.push(ch1);
                                }else{
                                    while (!bracket.isEmpty()){
                                        sb.append(bracket.pop());
                                    }
                                }
                                break;
                            case '*':
                                while (!bracket.isEmpty()&&bracket.peek()=='*'){
                                    sb.append(bracket.pop());
                                }
                                bracket.push(ch1);
                                break;
                            default:
                                if(ch1==')')continue;
                                sb.append(ch1);
                                break;
                        }
                    }
                    while (!bracket.isEmpty()) {
                        sb.append(bracket.pop());
                    }


                } else {
                    char ch = str.charAt(i);
                    switch (ch) {
                        case '+':
                            if(sign.isEmpty()){
                                sign.push(ch);
                            }else{
                                while (!sign.isEmpty()){
                                    sb.append(sign.pop());
                                }
                            }
                            break;
                        case '*':
                            while (!sign.isEmpty()&&sign.peek()=='*'){
                                sb.append(sign.pop());
                            }
                            sign.push(ch);
                            break;
                        default:
                            sb.append(ch);
                            break;
                    }
                }
            }
            while (!sign.isEmpty()) {
                sb.append(sign.pop());
            }
            //계산하기
            Stack<Integer> ch = new Stack();
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i)>=48&& sb.charAt(i)<=59){
                    ch.push(sb.charAt(i)-'0');
                }else{
                    int num1 = ch.pop();
                    int num2 = ch.pop();
                    if(sb.charAt(i)=='+'){
                        ch.push(num1+num2);
                    }else{
                        ch.push(num1*num2);
                    }
                }
            }
            System.out.println("#"+test_case+" "+ch.pop());
        }
    }
}
