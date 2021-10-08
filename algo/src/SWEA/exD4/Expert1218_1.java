package SWEA.exD4;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Expert1218_1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1218.txt"));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T  =10;
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            Stack<Character> ch = new Stack<>();
            String str = br.readLine();
            boolean flag = true;

            for (int j = 0; j < n; j++) {
                if(str.charAt(j)==')'){
                    if(ch.peek()=='('){
                        ch.pop();
                    }else{
                        flag=false;
                        break;
                    }
                }else if(str.charAt(j)==']'){
                    if(ch.peek()=='['){
                        ch.pop();
                    }else{
                        flag=false;
                        break;
                    }
                }else if(str.charAt(j)=='>'){
                    if(ch.peek()=='<'){
                        ch.pop();
                    }else{
                        flag=false;
                        break;
                    }
                }else if(str.charAt(j)=='}'){
                    if(ch.peek()=='{'){
                        ch.pop();
                    }else{
                        flag=false;
                        break;
                    }
                }else{
                    ch.push(str.charAt(j));
                }
            }
            if (!ch.isEmpty()) {
                flag = false;
            }
            if(flag){
                System.out.println("#"+i+" "+"1");
            }else{
                System.out.println("#"+i+" "+"0");
            }
        }


    }
}
